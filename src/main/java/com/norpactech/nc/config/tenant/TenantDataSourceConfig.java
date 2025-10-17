package com.norpactech.nc.config.tenant;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TenantDataSourceConfig {

  @Bean
  @ConfigurationProperties("spring.datasource")
  DataSourceProperties dataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean("actualDataSource")
  DataSource actualDataSource() {
    return dataSourceProperties()
        .initializeDataSourceBuilder()
        .build();
  }

  @Bean
  @Primary
  DataSource tenantAwareDataSource(@Qualifier("actualDataSource") DataSource dataSource) {
    return new TenantAwareDataSource(dataSource);
  }
}