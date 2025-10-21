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
import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: Pricing - Created pricing from Import
 */
public class Pricing extends BaseModel {

  private UUID id;
  private UUID idProduct;
  private UUID idRtPricingType;
  private UUID idRtBillingPeriod;
  private UUID idRtCurrencyCode;
  private Double amount;
  private Double ratePerUnit;
  private Double minimumCharge;
  private LocalDateTime validFrom;
  private LocalDateTime validTo;
  private Gson metadata;
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public Pricing () {}
  public Pricing (Object obj) {
    super(obj);
  }

  public Pricing (
    UUID id,
    UUID idProduct,
    UUID idRtPricingType,
    UUID idRtBillingPeriod,
    UUID idRtCurrencyCode,
    Double amount,
    Double ratePerUnit,
    Double minimumCharge,
    LocalDateTime validFrom,
    LocalDateTime validTo,
    Gson metadata,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.id = id;
    this.idProduct = idProduct;
    this.idRtPricingType = idRtPricingType;
    this.idRtBillingPeriod = idRtBillingPeriod;
    this.idRtCurrencyCode = idRtCurrencyCode;
    this.amount = amount;
    this.ratePerUnit = ratePerUnit;
    this.minimumCharge = minimumCharge;
    this.validFrom = validFrom;
    this.validTo = validTo;
    this.metadata = metadata;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, Pricing.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.pricing.* " + 
      "FROM norpac_commons.pricing");
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
    
  public UUID getIdRtPricingType() {
    return this.idRtPricingType;
  }
    
  public UUID setIdRtPricingType(UUID idRtPricingType) {
    return this.idRtPricingType = idRtPricingType;
  }    
    
  public UUID getIdRtBillingPeriod() {
    return this.idRtBillingPeriod;
  }
    
  public UUID setIdRtBillingPeriod(UUID idRtBillingPeriod) {
    return this.idRtBillingPeriod = idRtBillingPeriod;
  }    
    
  public UUID getIdRtCurrencyCode() {
    return this.idRtCurrencyCode;
  }
    
  public UUID setIdRtCurrencyCode(UUID idRtCurrencyCode) {
    return this.idRtCurrencyCode = idRtCurrencyCode;
  }    
    
  public Double getAmount() {
    return this.amount;
  }
    
  public Double setAmount(Double amount) {
    return this.amount = amount;
  }    
    
  public Double getRatePerUnit() {
    return this.ratePerUnit;
  }
    
  public Double setRatePerUnit(Double ratePerUnit) {
    return this.ratePerUnit = ratePerUnit;
  }    
    
  public Double getMinimumCharge() {
    return this.minimumCharge;
  }
    
  public Double setMinimumCharge(Double minimumCharge) {
    return this.minimumCharge = minimumCharge;
  }    
    
  public LocalDateTime getValidFrom() {
    return this.validFrom;
  }
    
  public LocalDateTime setValidFrom(LocalDateTime validFrom) {
    return this.validFrom = validFrom;
  }    
    
  public LocalDateTime getValidTo() {
    return this.validTo;
  }
    
  public LocalDateTime setValidTo(LocalDateTime validTo) {
    return this.validTo = validTo;
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