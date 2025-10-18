package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created bundle_item from Import
 */
 public class BundleItemPostApiRequest {

  private UUID idBundle;
  private UUID idChildProduct;
  private Integer sequence;
  private Integer quantity;
  private Boolean optional;
  private String createdBy;

  public BundleItemPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_bundle_item(?,?,?,?,?,?)");
    request.put("idBundle", this.idBundle);
    request.put("idChildProduct", this.idChildProduct);
    request.put("sequence", this.sequence);
    request.put("quantity", this.quantity);
    request.put("optional", this.optional);
    request.put("createdBy", this.createdBy);
    return request;
  }
  
  // Getters and Setters...
    
  public UUID getIdBundle() {
    return this.idBundle;
  }
    
  public UUID setIdBundle(UUID idBundle) {
    return this.idBundle = idBundle;
  }    
    
  public UUID getIdChildProduct() {
    return this.idChildProduct;
  }
    
  public UUID setIdChildProduct(UUID idChildProduct) {
    return this.idChildProduct = idChildProduct;
  }    
    
  public Integer getSequence() {
    return this.sequence;
  }
    
  public Integer setSequence(Integer sequence) {
    return this.sequence = sequence;
  }    
    
  public Integer getQuantity() {
    return this.quantity;
  }
    
  public Integer setQuantity(Integer quantity) {
    return this.quantity = quantity;
  }    
    
  public Boolean getOptional() {
    return this.optional;
  }
    
  public Boolean setOptional(Boolean optional) {
    return this.optional = optional;
  }    
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}