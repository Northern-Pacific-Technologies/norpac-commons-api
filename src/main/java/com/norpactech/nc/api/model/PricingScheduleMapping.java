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
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: PricingScheduleMapping - Created pricing_schedule_mapping from Import
 */
public class PricingScheduleMapping extends BaseModel {

  private UUID id;
  private UUID idPricing;
  private UUID idScheduleRule;
  private LocalDateTime effectiveDate;
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public PricingScheduleMapping () {}
  public PricingScheduleMapping (Object obj) {
    super(obj);
  }

  public PricingScheduleMapping (
    UUID id,
    UUID idPricing,
    UUID idScheduleRule,
    LocalDateTime effectiveDate,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.id = id;
    this.idPricing = idPricing;
    this.idScheduleRule = idScheduleRule;
    this.effectiveDate = effectiveDate;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, PricingScheduleMapping.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.pricing_schedule_mapping.* " + 
      "FROM norpac_commons.pricing_schedule_mapping");
    return matchedParams;
  }

  // Getters and Setters...
    
  public UUID getId() {
    return this.id;
  }
    
  public UUID setId(UUID id) {
    return this.id = id;
  }    
    
  public UUID getIdPricing() {
    return this.idPricing;
  }
    
  public UUID setIdPricing(UUID idPricing) {
    return this.idPricing = idPricing;
  }    
    
  public UUID getIdScheduleRule() {
    return this.idScheduleRule;
  }
    
  public UUID setIdScheduleRule(UUID idScheduleRule) {
    return this.idScheduleRule = idScheduleRule;
  }    
    
  public LocalDateTime getEffectiveDate() {
    return this.effectiveDate;
  }
    
  public LocalDateTime setEffectiveDate(LocalDateTime effectiveDate) {
    return this.effectiveDate = effectiveDate;
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