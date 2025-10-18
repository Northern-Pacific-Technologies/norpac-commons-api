package com.norpactech.nc.api.model;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import com.norpactech.nc.model.BaseModel;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: SubscriptionPlan - Created subscription_plan from Import
 */
public class SubscriptionPlan extends BaseModel {

  private UUID id;
  private UUID idProduct;
  private UUID idRtBillingFrequency;
  private UUID idRtCurrencyCode;
  private UUID idRtRenewalPolicy;
  private String planName;
  private Double basePrice;
  private Integer trialPeriodDays;
  private String recurrenceRule;
  private Gson metadata;
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public SubscriptionPlan () {}
  public SubscriptionPlan (Object obj) {
    super(obj);
  }

  public SubscriptionPlan (
    UUID id,
    UUID idProduct,
    UUID idRtBillingFrequency,
    UUID idRtCurrencyCode,
    UUID idRtRenewalPolicy,
    String planName,
    Double basePrice,
    Integer trialPeriodDays,
    String recurrenceRule,
    Gson metadata,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.id = id;
    this.idProduct = idProduct;
    this.idRtBillingFrequency = idRtBillingFrequency;
    this.idRtCurrencyCode = idRtCurrencyCode;
    this.idRtRenewalPolicy = idRtRenewalPolicy;
    this.planName = planName;
    this.basePrice = basePrice;
    this.trialPeriodDays = trialPeriodDays;
    this.recurrenceRule = recurrenceRule;
    this.metadata = metadata;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, SubscriptionPlan.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.subscription_plan.* " + 
      "FROM norpac_commons.subscription_plan");
    return matchedParams;
  }

  // Getters and Setters...
    
  public UUID getId() {
    return this.id;
  }
    
  public UUID setId(UUID id) {
    return this.id = id;
  }    
    
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