package com.norpactech.nc.api.model;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import com.norpactech.nc.model.BaseModel;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.String;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: ProductFeatureMapping - Created product_feature_mapping from Import
 */
public class ProductFeatureMapping extends BaseModel {

  private UUID id;
  private UUID idProduct;
  private UUID idFeature;
  private Boolean included;
  private Double addonPrice;
  private Gson metadata;
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public ProductFeatureMapping () {}
  public ProductFeatureMapping (Object obj) {
    super(obj);
  }

  public ProductFeatureMapping (
    UUID id,
    UUID idProduct,
    UUID idFeature,
    Boolean included,
    Double addonPrice,
    Gson metadata,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.id = id;
    this.idProduct = idProduct;
    this.idFeature = idFeature;
    this.included = included;
    this.addonPrice = addonPrice;
    this.metadata = metadata;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, ProductFeatureMapping.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.product_feature_mapping.* " + 
      "FROM norpac_commons.product_feature_mapping");
    return matchedParams;
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