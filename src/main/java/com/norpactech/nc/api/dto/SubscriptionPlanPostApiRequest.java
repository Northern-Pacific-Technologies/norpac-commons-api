package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created subscription_plan from Import
 */
 public class SubscriptionPlanPostApiRequest {

  private UUID idProduct;
  private UUID idRtBillingFrequency;
  private UUID idRtCurrencyCode;
  private UUID idRtRenewalPolicy;
  private String planName;
  private Double basePrice;
  private Integer trialPeriodDays;
  private String recurrenceRule;
  private Gson metadata;
  private String createdBy;

  public SubscriptionPlanPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_subscription_plan(?,?,?,?,?,?,?,?,?,?)");
    request.put("idProduct", this.idProduct);
    request.put("idRtBillingFrequency", this.idRtBillingFrequency);
    request.put("idRtCurrencyCode", this.idRtCurrencyCode);
    request.put("idRtRenewalPolicy", this.idRtRenewalPolicy);
    request.put("planName", this.planName);
    request.put("basePrice", this.basePrice);
    request.put("trialPeriodDays", this.trialPeriodDays);
    request.put("recurrenceRule", this.recurrenceRule);
    request.put("metadata", this.metadata);
    request.put("createdBy", this.createdBy);
    return request;
  }
  
  // Getters and Setters...
    
  public UUID getIdProduct() {
    return this.idProduct;
  }
    
  public UUID setIdProduct(UUID idProduct) {
    return this.idProduct = idProduct;
  }    
    
  public UUID getIdRtBillingFrequency() {
    return this.idRtBillingFrequency;
  }
    
  public UUID setIdRtBillingFrequency(UUID idRtBillingFrequency) {
    return this.idRtBillingFrequency = idRtBillingFrequency;
  }    
    
  public UUID getIdRtCurrencyCode() {
    return this.idRtCurrencyCode;
  }
    
  public UUID setIdRtCurrencyCode(UUID idRtCurrencyCode) {
    return this.idRtCurrencyCode = idRtCurrencyCode;
  }    
    
  public UUID getIdRtRenewalPolicy() {
    return this.idRtRenewalPolicy;
  }
    
  public UUID setIdRtRenewalPolicy(UUID idRtRenewalPolicy) {
    return this.idRtRenewalPolicy = idRtRenewalPolicy;
  }    
    
  public String getPlanName() {
    return this.planName;
  }
    
  public String setPlanName(String planName) {
    return this.planName = planName;
  }    
    
  public Double getBasePrice() {
    return this.basePrice;
  }
    
  public Double setBasePrice(Double basePrice) {
    return this.basePrice = basePrice;
  }    
    
  public Integer getTrialPeriodDays() {
    return this.trialPeriodDays;
  }
    
  public Integer setTrialPeriodDays(Integer trialPeriodDays) {
    return this.trialPeriodDays = trialPeriodDays;
  }    
    
  public String getRecurrenceRule() {
    return this.recurrenceRule;
  }
    
  public String setRecurrenceRule(String recurrenceRule) {
    return this.recurrenceRule = recurrenceRule;
  }    
    
  public Gson getMetadata() {
    return this.metadata;
  }
    
  public Gson setMetadata(Gson metadata) {
    return this.metadata = metadata;
  }    
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}