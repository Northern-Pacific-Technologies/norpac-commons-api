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
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Put API Request
 * 
 * Created product_feature_mapping from Import
 */
public class ProductFeatureMappingPutApiRequest {

  private UUID id;
  private UUID idProduct;
  private UUID idFeature;
  private Boolean included;
  private Double addonPrice;
  private Gson metadata;
  private Timestamp updatedAt;
  private String updatedBy;

  public ProductFeatureMappingPutApiRequest () {}

  @Hidden
  public Map<String, Object> getUpdateRequest() {
    
     var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.u_product_feature_mapping(?,?,?,?,?,?,?,?)");
    request.put("id", this.id);
    request.put("idProduct", this.idProduct);
    request.put("idFeature", this.idFeature);
    request.put("included", this.included);
    request.put("addonPrice", this.addonPrice);
    request.put("metadata", this.metadata);
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