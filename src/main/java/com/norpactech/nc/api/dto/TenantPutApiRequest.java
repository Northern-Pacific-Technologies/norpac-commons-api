package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.lang.String;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Put API Request
 * 
 * Created tenant from Import
 */
public class TenantPutApiRequest {

  private UUID id;
  private String name;
  private String description;
  private String origin;
  private String originName;
  private String alias;
  private String timeZone;
  private Timestamp updatedAt;
  private String updatedBy;

  public TenantPutApiRequest () {}

  @Hidden
  public Map<String, Object> getUpdateRequest() {
    
     var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.u_tenant(?,?,?,?,?,?,?,?,?)");
    request.put("id", this.id);
    request.put("name", this.name);
    request.put("description", this.description);
    request.put("origin", this.origin);
    request.put("originName", this.originName);
    request.put("alias", this.alias);
    request.put("timeZone", this.timeZone);
    request.put("updatedAt", this.updatedAt);
    request.put("updatedBy", this.updatedBy);
    return request;
  }
  
  // Getters and Setters...
    
  public UUID getId() {
    return this.id;
  }
    
  public UUID setId(UUID id) {
    return this.id = id;
  }    
    
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
    
  public Timestamp getUpdatedAt() {
    return this.updatedAt;
  }
    
  public Timestamp setUpdatedAt(Timestamp updatedAt) {
    return this.updatedAt = updatedAt;
  }    
    
  public String getUpdatedBy() {
    return this.updatedBy;
  }
    
  public String setUpdatedBy(String updatedBy) {
    return this.updatedBy = updatedBy;
  }    
}