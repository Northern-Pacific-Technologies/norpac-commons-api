package com.norpactech.nc.api.model;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.norpactech.nc.model.BaseModel;
import java.lang.Boolean;
import java.lang.String;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: Tenant - Created tenant from Import
 */
public class Tenant extends BaseModel {

  private UUID id;
  private String name;
  private String description;
  private String origin;
  private String originName;
  private String alias;
  private String timeZone;
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public Tenant () {}
  public Tenant (Object obj) {
    super(obj);
  }

  public Tenant (
    UUID id,
    String name,
    String description,
    String origin,
    String originName,
    String alias,
    String timeZone,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.id = id;
    this.name = name;
    this.description = description;
    this.origin = origin;
    this.originName = originName;
    this.alias = alias;
    this.timeZone = timeZone;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, Tenant.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.tenant.* " + 
      "FROM norpac_commons.tenant");
    return matchedParams;
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
    
  public Timestamp getCreatedAt() {
    return this.createdAt;
  }
    
  public Timestamp setCreatedAt(Timestamp createdAt) {
    return this.createdAt = createdAt;
  }    
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
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
    
  public Boolean getIsActive() {
    return this.isActive;
  }
    
  public Boolean setIsActive(Boolean isActive) {
    return this.isActive = isActive;
  }    
}