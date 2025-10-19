package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
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
 * Created coupon_usage from Import
 */
public class CouponUsagePutApiRequest {

  private UUID id;
  private UUID idCoupon;
  private UUID idCustomer;
  private UUID idServiceOrder;
  private LocalDateTime usedAt;
  private Timestamp updatedAt;
  private String updatedBy;

  public CouponUsagePutApiRequest () {}

  @Hidden
  public Map<String, Object> getUpdateRequest() {
    
     var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.u_coupon_usage(?,?,?,?,?,?,?)");
    request.put("id", this.id);
    request.put("idCoupon", this.idCoupon);
    request.put("idCustomer", this.idCustomer);
    request.put("idServiceOrder", this.idServiceOrder);
    request.put("usedAt", this.usedAt);
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