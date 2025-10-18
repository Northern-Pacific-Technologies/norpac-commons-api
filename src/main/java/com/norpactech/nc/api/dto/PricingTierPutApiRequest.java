package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Put API Request
 * 
 * Created pricing_tier from Import
 */
public class PricingTierPutApiRequest {

  private UUID id;
  private UUID idPricing;
  private Integer minQuantity;
  private Integer maxQuantity;
  private Double pricePerUnit;
  private Timestamp updatedAt;
  private String updatedBy;

  public PricingTierPutApiRequest () {}

  @Hidden
  public Map<String, Object> getUpdateRequest() {
    
     var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.u_pricing_tier(?,?,?,?,?,?,?)");
    request.put("id", this.id);
    request.put("idPricing", this.idPricing);
    request.put("minQuantity", this.minQuantity);
    request.put("maxQuantity", this.maxQuantity);
    request.put("pricePerUnit", this.pricePerUnit);
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