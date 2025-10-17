package com.norpactech.nc.config.tenant;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DelegatingDataSource;

public class TenantAwareDataSource extends DelegatingDataSource {

  public TenantAwareDataSource(DataSource targetDataSource) {
    super(targetDataSource);
  }
  
  @Override
  public Connection getConnection() {
    try {
      Connection physical = super.getConnection();
      String idTenant = TenantContext.getIdTenant();
      
      // Always clear any existing tenant context first to avoid pollution
      try (PreparedStatement clearPs = physical.prepareStatement("SELECT set_config('app.current_tenant', '', false)")) {
        clearPs.execute();
      }

      if (RequestContext.requiresTenantContext()) {
        if (idTenant == null) {
          throw new IllegalStateException(
            "Tenant context required for URL pattern /v*/**. " +
            "Current request: " + RequestContext.getCurrentRequestUri()
          );
        }
        try (PreparedStatement ps = physical.prepareStatement("SELECT set_config('app.current_tenant', ?, false)")) {
          ps.setString(1, idTenant);
          ps.execute();
        }
        // Verify the tenant was set correctly
        try (PreparedStatement verifyPs = physical.prepareStatement("SELECT current_setting('app.current_tenant', true)")) {
          var rs = verifyPs.executeQuery();
          if (rs.next()) {
            String actualTenant = rs.getString(1);
            if (!idTenant.equals(actualTenant)) {
              throw new IllegalStateException("Tenant context verification failed. Expected: " + idTenant + ", Actual: " + actualTenant);
            }
          }
        }        
        return createTenantResettingProxy(physical);
      }
      return physical;
    } 
    catch (RuntimeException e) {
      throw e;
    } 
    catch (Exception e) {
      throw new RuntimeException("Failed to set tenant on connection", e);
    }
  }

  private Connection createTenantResettingProxy(Connection physical) {
    return (Connection) Proxy.newProxyInstance(
        physical.getClass().getClassLoader(),
        new Class[]{Connection.class},
        (proxy, method, args) -> {
          if ("close".equals(method.getName())) {
            try (PreparedStatement ps = physical.prepareStatement("SELECT set_config('app.current_tenant', '', false)")) {
              ps.execute();
            } 
            catch (Exception ignored) {}
          }
          return method.invoke(physical, args);
        });
  }
}