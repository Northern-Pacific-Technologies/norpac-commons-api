package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created coupon from Import
 */
 public class CouponPostApiRequest {

  private UUID idTenant;
  private UUID idRtCouponType;
  private String name;
  private String code;
  private String description;
  private Double amount;
  private Integer maxUses;
  private Integer maxUsesPerCustomer;
  private LocalDateTime validFrom;
  private LocalDateTime validTo;
  private String createdBy;

  public CouponPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_coupon(?,?,?,?,?,?,?,?,?,?,?)");
    request.put("idTenant", this.idTenant);
    request.put("idRtCouponType", this.idRtCouponType);
    request.put("name", this.name);
    request.put("code", this.code);
    request.put("description", this.description);
    request.put("amount", this.amount);
    request.put("maxUses", this.maxUses);
    request.put("maxUsesPerCustomer", this.maxUsesPerCustomer);
    request.put("validFrom", this.validFrom);
    request.put("validTo", this.validTo);
    request.put("createdBy", this.createdBy);
    return request;
  }
  
  // Getters and Setters...
    
  public UUID getIdTenant() {
    return this.idTenant;
  }
    
  public UUID setIdTenant(UUID idTenant) {
    return this.idTenant = idTenant;
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
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}