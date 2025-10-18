package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import java.lang.Double;
import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Put API Request
 * 
 * Created pricing from Import
 */
public class PricingPutApiRequest {

  private UUID id;
  private UUID idServiceProduct;
  private UUID idRtPricingType;
  private UUID idRtBillingPeriod;
  private UUID idRtCurrencyCode;
  private Double amount;
  private LocalDateTime validFrom;
  private LocalDateTime validTo;
  private Gson metadata;
  private Timestamp updatedAt;
  private String updatedBy;

  public PricingPutApiRequest () {}

  @Hidden
  public Map<String, Object> getUpdateRequest() {
    
     var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.u_pricing(?,?,?,?,?,?,?,?,?,?,?)");
    request.put("id", this.id);
    request.put("idServiceProduct", this.idServiceProduct);
    request.put("idRtPricingType", this.idRtPricingType);
    request.put("idRtBillingPeriod", this.idRtBillingPeriod);
    request.put("idRtCurrencyCode", this.idRtCurrencyCode);
    request.put("amount", this.amount);
    request.put("validFrom", this.validFrom);
    request.put("validTo", this.validTo);
    request.put("metadata", this.metadata);
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
    
  public UUID getIdServiceProduct() {
    return this.idServiceProduct;
  }
    
  public UUID setIdServiceProduct(UUID idServiceProduct) {
    return this.idServiceProduct = idServiceProduct;
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