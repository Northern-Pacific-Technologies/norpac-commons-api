package com.norpactech.nc.api.model;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.norpactech.nc.model.BaseModel;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: CouponProduct - Created coupon_product from Import
 */
public class CouponProduct extends BaseModel {

  private UUID idCoupon;
  private UUID idProduct;

  public CouponProduct () {}
  public CouponProduct (Object obj) {
    super(obj);
  }

  public CouponProduct (
    UUID idCoupon,
    UUID idProduct)
 {
    this.idCoupon = idCoupon;
    this.idProduct = idProduct;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, CouponProduct.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.coupon_product.* " + 
      "FROM norpac_commons.coupon_product");
    return matchedParams;
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