package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
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
 * Created pricing_tier from Import
 */
 public class PricingTierPostApiRequest {

  private UUID idPricing;
  private Integer minQuantity;
  private Integer maxQuantity;
  private Double pricePerUnit;
  private String createdBy;

  public PricingTierPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_pricing_tier(?,?,?,?,?)");
    request.put("idPricing", this.idPricing);
    request.put("minQuantity", this.minQuantity);
    request.put("maxQuantity", this.maxQuantity);
    request.put("pricePerUnit", this.pricePerUnit);
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
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}