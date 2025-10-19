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
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Put API Request
 * 
 * Created coupon from Import
 */
public class CouponPutApiRequest {

  private UUID id;
  private UUID idRtCouponType;
  private String name;
  private String code;
  private String description;
  private Double amount;
  private Integer maxUses;
  private Integer maxUsesPerCustomer;
  private LocalDateTime validFrom;
  private LocalDateTime validTo;
  private Timestamp updatedAt;
  private String updatedBy;

  public CouponPutApiRequest () {}

  @Hidden
  public Map<String, Object> getUpdateRequest() {
    
     var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.u_coupon(?,?,?,?,?,?,?,?,?,?,?,?)");
    request.put("id", this.id);
    request.put("idRtCouponType", this.idRtCouponType);
    request.put("name", this.name);
    request.put("code", this.code);
    request.put("description", this.description);
    request.put("amount", this.amount);
    request.put("maxUses", this.maxUses);
    request.put("maxUsesPerCustomer", this.maxUsesPerCustomer);
    request.put("validFrom", this.validFrom);
    request.put("validTo", this.validTo);
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
    
  public UUID getIdRtCouponType() {
    return this.idRtCouponType;
  }
    
  public UUID setIdRtCouponType(UUID idRtCouponType) {
    return this.idRtCouponType = idRtCouponType;
  }    
    
  public String getName() {
    return this.name;
  }
    
  public String setName(String name) {
    return this.name = name;
  }    
    
  public String getCode() {
    return this.code;
  }
    
  public String setCode(String code) {
    return this.code = code;
  }    
    
  public String getDescription() {
    return this.description;
  }
    
  public String setDescription(String description) {
    return this.description = description;
  }    
    
  public Double getAmount() {
    return this.amount;
  }
    
  public Double setAmount(Double amount) {
    return this.amount = amount;
  }    
    
  public Integer getMaxUses() {
    return this.maxUses;
  }
    
  public Integer setMaxUses(Integer maxUses) {
    return this.maxUses = maxUses;
  }    
    
  public Integer getMaxUsesPerCustomer() {
    return this.maxUsesPerCustomer;
  }
    
  public Integer setMaxUsesPerCustomer(Integer maxUsesPerCustomer) {
    return this.maxUsesPerCustomer = maxUsesPerCustomer;
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