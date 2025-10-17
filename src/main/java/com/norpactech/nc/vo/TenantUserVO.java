package com.norpactech.nc.vo;

import java.sql.ResultSet;
import java.util.UUID;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 * 
 * This software is proprietary and may not be used, copied, modified, or distributed 
 * without permission. It is provided "as is" without warranties of any kind. 
 * 
 * For details, see the LICENSE file in this project root.
 */
public class TenantUserVO {

  private String idTenant;
  private String idUser;
  private String tenantName;
  private String email;
  
  public TenantUserVO(ResultSet rs) throws Exception {

    this.idTenant =  ((UUID) rs.getObject("id_tenant")).toString();
    this.idUser =  ((UUID) rs.getObject("id_user")).toString();
    this.tenantName = rs.getString("tenant_name");
    this.email = rs.getString("email");
  }
  
  public String getIdTenant() {
    return idTenant;
  }
  public void setIdTenant(String idTenant) {
    this.idTenant = idTenant;
  }
  public String getIdUser() {
    return idUser;
  }
  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }
  public String getTenantName() {
    return tenantName;
  }
  public void setTenantName(String tenantName) {
    this.tenantName = tenantName;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
}