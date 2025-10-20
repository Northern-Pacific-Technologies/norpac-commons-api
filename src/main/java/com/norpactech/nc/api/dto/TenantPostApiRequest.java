package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.lang.String;
import java.util.Map;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created tenant from Import
 */
 public class TenantPostApiRequest {

  private String name;
  private String description;
  private String origin;
  private String originName;
  private String alias;
  private String timeZone;
  private String createdBy;

  public TenantPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_tenant(?,?,?,?,?,?,?)");
    request.put("name", this.name);
    request.put("description", this.description);
    request.put("origin", this.origin);
    request.put("originName", this.originName);
    request.put("alias", this.alias);
    request.put("timeZone", this.timeZone);
    request.put("createdBy", this.createdBy);
    return request;
  }
  
  // Getters and Setters...
    
  public String getName() {
    return this.name;
  }
    
  public String setName(String name) {
    return this.name = name;
  }    
    
  public String getDescription() {
    return this.description;
  }
    
  public String setDescription(String description) {
    return this.description = description;
  }    
    
  public String getOrigin() {
    return this.origin;
  }
    
  public String setOrigin(String origin) {
    return this.origin = origin;
  }    
    
  public String getOriginName() {
    return this.originName;
  }
    
  public String setOriginName(String originName) {
    return this.originName = originName;
  }    
    
  public String getAlias() {
    return this.alias;
  }
    
  public String setAlias(String alias) {
    return this.alias = alias;
  }    
    
  public String getTimeZone() {
    return this.timeZone;
  }
    
  public String setTimeZone(String timeZone) {
    return this.timeZone = timeZone;
  }    
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}