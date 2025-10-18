package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.lang.String;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Activate/Deactivate API Request
 * 
 * Created product_service_details from Import
 */
public class ProductServiceDetailsActiveApiRequest {

  private UUID idProduct;
  private Timestamp updatedAt;
  private String updatedBy;

  public ProductServiceDetailsActiveApiRequest () {}

  @Hidden
  public Map<String, Object> getDeactRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.deact_product_service_details(?,?,?)");
    request.put("idProduct", this.idProduct);
    request.put("updatedAt", this.updatedAt);
    request.put("updatedBy", this.updatedBy);
    return request;
  }

  @Hidden
  public Map<String, Object> getReactRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.react_product_service_details(?,?,?)");
    request.put("idProduct", this.idProduct);
    request.put("updatedAt", this.updatedAt);
    request.put("updatedBy", this.updatedBy);
    return request;
  }
  
  // Getters and Setters...
    
  public UUID getIdProduct() {
    return this.idProduct;
  }
    
  public UUID setIdProduct(UUID idProduct) {
    return this.idProduct = idProduct;
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