package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.lang.String;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created pricing_schedule_mapping from Import
 */
 public class PricingScheduleMappingPostApiRequest {

  private UUID idPricing;
  private UUID idScheduleRule;
  private LocalDateTime effectiveDate;
  private String createdBy;

  public PricingScheduleMappingPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_pricing_schedule_mapping(?,?,?,?)");
    request.put("idPricing", this.idPricing);
    request.put("idScheduleRule", this.idScheduleRule);
    request.put("effectiveDate", this.effectiveDate);
    request.put("createdBy", this.createdBy);
    return request;
  }
  
  // Getters and Setters...
    
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
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}