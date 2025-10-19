package com.norpactech.nc.api.model;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.norpactech.nc.model.BaseModel;
import java.lang.Boolean;
import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: CouponUsage - Created coupon_usage from Import
 */
public class CouponUsage extends BaseModel {

  private UUID id;
  private UUID idCoupon;
  private UUID idCustomer;
  private UUID idServiceOrder;
  private LocalDateTime usedAt;
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public CouponUsage () {}
  public CouponUsage (Object obj) {
    super(obj);
  }

  public CouponUsage (
    UUID id,
    UUID idCoupon,
    UUID idCustomer,
    UUID idServiceOrder,
    LocalDateTime usedAt,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.id = id;
    this.idCoupon = idCoupon;
    this.idCustomer = idCustomer;
    this.idServiceOrder = idServiceOrder;
    this.usedAt = usedAt;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, CouponUsage.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.coupon_usage.* " + 
      "FROM norpac_commons.coupon_usage");
    return matchedParams;
  }

  // Getters and Setters...
    
  public UUID getId() {
    return this.id;
  }
    
  public UUID setId(UUID id) {
    return this.id = id;
  }    
    
  public UUID getIdCoupon() {
    return this.idCoupon;
  }
    
  public UUID setIdCoupon(UUID idCoupon) {
    return this.idCoupon = idCoupon;
  }    
    
  public UUID getIdCustomer() {
    return this.idCustomer;
  }
    
  public UUID setIdCustomer(UUID idCustomer) {
    return this.idCustomer = idCustomer;
  }    
    
  public UUID getIdServiceOrder() {
    return this.idServiceOrder;
  }
    
  public UUID setIdServiceOrder(UUID idServiceOrder) {
    return this.idServiceOrder = idServiceOrder;
  }    
    
  public LocalDateTime getUsedAt() {
    return this.usedAt;
  }
    
  public LocalDateTime setUsedAt(LocalDateTime usedAt) {
    return this.usedAt = usedAt;
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