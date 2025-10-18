package com.norpactech.nc.api.model;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.norpactech.nc.model.BaseModel;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: BundleItem - Created bundle_item from Import
 */
public class BundleItem extends BaseModel {

  private UUID id;
  private UUID idBundle;
  private UUID idChildProduct;
  private Integer sequence;
  private Integer quantity;
  private Boolean optional;
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public BundleItem () {}
  public BundleItem (Object obj) {
    super(obj);
  }

  public BundleItem (
    UUID id,
    UUID idBundle,
    UUID idChildProduct,
    Integer sequence,
    Integer quantity,
    Boolean optional,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.id = id;
    this.idBundle = idBundle;
    this.idChildProduct = idChildProduct;
    this.sequence = sequence;
    this.quantity = quantity;
    this.optional = optional;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, BundleItem.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.bundle_item.* " + 
      "FROM norpac_commons.bundle_item");
    return matchedParams;
  }

  // Getters and Setters...
    
  public UUID getId() {
    return this.id;
  }
    
  public UUID setId(UUID id) {
    return this.id = id;
  }    
    
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