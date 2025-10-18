package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.String;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created product_feature_mapping from Import
 */
 public class ProductFeatureMappingPostApiRequest {

  private UUID idProduct;
  private UUID idFeature;
  private Boolean included;
  private Double addonPrice;
  private Gson metadata;
  private String createdBy;

  public ProductFeatureMappingPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_product_feature_mapping(?,?,?,?,?,?)");
    request.put("idProduct", this.idProduct);
    request.put("idFeature", this.idFeature);
    request.put("included", this.included);
    request.put("addonPrice", this.addonPrice);
    request.put("metadata", this.metadata);
    request.put("createdBy", this.createdBy);
    return request;
  }
  
  // Getters and Setters...
    
  public UUID getIdProduct() {
    return this.idProduct;
  }
    
  public UUID setIdProduct(UUID idProduct) {
    return this.idProduct = idProduct;
  }    
    
  public UUID getIdFeature() {
    return this.idFeature;
  }
    
  public UUID setIdFeature(UUID idFeature) {
    return this.idFeature = idFeature;
  }    
    
  public Boolean getIncluded() {
    return this.included;
  }
    
  public Boolean setIncluded(Boolean included) {
    return this.included = included;
  }    
    
  public Double getAddonPrice() {
    return this.addonPrice;
  }
    
  public Double setAddonPrice(Double addonPrice) {
    return this.addonPrice = addonPrice;
  }    
    
  public Gson getMetadata() {
    return this.metadata;
  }
    
  public Gson setMetadata(Gson metadata) {
    return this.metadata = metadata;
  }    
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}