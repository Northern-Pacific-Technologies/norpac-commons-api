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
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: Coupon - Created coupon from Import
 */
public class Coupon extends BaseModel {

  private UUID id;
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
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public Coupon () {}
  public Coupon (Object obj) {
    super(obj);
  }

  public Coupon (
    UUID id,
    UUID idTenant,
    UUID idRtCouponType,
    String name,
    String code,
    String description,
    Double amount,
    Integer maxUses,
    Integer maxUsesPerCustomer,
    LocalDateTime validFrom,
    LocalDateTime validTo,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.id = id;
    this.idTenant = idTenant;
    this.idRtCouponType = idRtCouponType;
    this.name = name;
    this.code = code;
    this.description = description;
    this.amount = amount;
    this.maxUses = maxUses;
    this.maxUsesPerCustomer = maxUsesPerCustomer;
    this.validFrom = validFrom;
    this.validTo = validTo;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, Coupon.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.coupon.* " + 
      "FROM norpac_commons.coupon");
    return matchedParams;
  }

  // Getters and Setters...
    
  public UUID getId() {
    return this.id;
  }
    
  public UUID setId(UUID id) {
    return this.id = id;
  }    
    
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