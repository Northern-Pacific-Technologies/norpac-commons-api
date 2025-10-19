package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.lang.String;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created coupon_usage from Import
 */
 public class CouponUsagePostApiRequest {

  private UUID idCoupon;
  private UUID idCustomer;
  private UUID idServiceOrder;
  private LocalDateTime usedAt;
  private String createdBy;

  public CouponUsagePostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_coupon_usage(?,?,?,?,?)");
    request.put("idCoupon", this.idCoupon);
    request.put("idCustomer", this.idCustomer);
    request.put("idServiceOrder", this.idServiceOrder);
    request.put("usedAt", this.usedAt);
    request.put("createdBy", this.createdBy);
    return request;
  }
  
  // Getters and Setters...
    
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
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}