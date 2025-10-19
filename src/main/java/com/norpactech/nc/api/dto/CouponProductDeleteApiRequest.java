package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Delete API Request
 * 
 * Created coupon_product from Import
 */
public class CouponProductDeleteApiRequest {

  private UUID idCoupon;
  private UUID idProduct;

  public CouponProductDeleteApiRequest () {}

  @Hidden
  public Map<String, Object> getDeleteRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.d_coupon_product(?,?)");
    request.put("idCoupon", this.idCoupon);
    request.put("idProduct", this.idProduct);
    return request;
  }
  
  // Getters and Setters...
    
  public UUID getIdCoupon() {
    return this.idCoupon;
  }
    
  public UUID setIdCoupon(UUID idCoupon) {
    return this.idCoupon = idCoupon;
  }    
    
  public UUID getIdProduct() {
    return this.idProduct;
  }
    
  public UUID setIdProduct(UUID idProduct) {
    return this.idProduct = idProduct;
  }    
}