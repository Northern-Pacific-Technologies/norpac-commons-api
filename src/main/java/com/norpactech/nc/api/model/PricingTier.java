package com.norpactech.nc.api.model;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.norpactech.nc.model.BaseModel;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: PricingTier - Created pricing_tier from Import
 */
public class PricingTier extends BaseModel {

  private UUID id;
  private UUID idPricing;
  private Integer minQuantity;
  private Integer maxQuantity;
  private Double pricePerUnit;
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public PricingTier () {}
  public PricingTier (Object obj) {
    super(obj);
  }

  public PricingTier (
    UUID id,
    UUID idPricing,
    Integer minQuantity,
    Integer maxQuantity,
    Double pricePerUnit,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.id = id;
    this.idPricing = idPricing;
    this.minQuantity = minQuantity;
    this.maxQuantity = maxQuantity;
    this.pricePerUnit = pricePerUnit;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, PricingTier.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.pricing_tier.* " + 
      "FROM norpac_commons.pricing_tier");
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
    
  public Integer getMinQuantity() {
    return this.minQuantity;
  }
    
  public Integer setMinQuantity(Integer minQuantity) {
    return this.minQuantity = minQuantity;
  }    
    
  public Integer getMaxQuantity() {
    return this.maxQuantity;
  }
    
  public Integer setMaxQuantity(Integer maxQuantity) {
    return this.maxQuantity = maxQuantity;
  }    
    
  public Double getPricePerUnit() {
    return this.pricePerUnit;
  }
    
  public Double setPricePerUnit(Double pricePerUnit) {
    return this.pricePerUnit = pricePerUnit;
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