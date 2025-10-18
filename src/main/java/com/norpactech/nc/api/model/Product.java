package com.norpactech.nc.api.model;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import com.norpactech.nc.model.BaseModel;
import java.lang.Boolean;
import java.lang.String;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: Product - Created product from Import
 */
public class Product extends BaseModel {

  private UUID id;
  private UUID idTenant;
  private UUID idRtProductType;
  private UUID idRtProductStatus;
  private UUID idRtProductCategory;
  private String name;
  private String code;
  private String description;
  private Gson metadata;
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public Product () {}
  public Product (Object obj) {
    super(obj);
  }

  public Product (
    UUID id,
    UUID idTenant,
    UUID idRtProductType,
    UUID idRtProductStatus,
    UUID idRtProductCategory,
    String name,
    String code,
    String description,
    Gson metadata,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.id = id;
    this.idTenant = idTenant;
    this.idRtProductType = idRtProductType;
    this.idRtProductStatus = idRtProductStatus;
    this.idRtProductCategory = idRtProductCategory;
    this.name = name;
    this.code = code;
    this.description = description;
    this.metadata = metadata;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, Product.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.product.* " + 
      "FROM norpac_commons.product");
    return matchedParams;
  }

  // Getters and Setters...
    
  public UUID getId() {
    return this.id;
  }
    
  public UUID setId(UUID id) {
    return this.id = id;
  }    
    
  public UUID getIdTenant() {
    return this.idTenant;
  }
    
  public UUID setIdTenant(UUID idTenant) {
    return this.idTenant = idTenant;
  }    
    
  public UUID getIdRtProductType() {
    return this.idRtProductType;
  }
    
  public UUID setIdRtProductType(UUID idRtProductType) {
    return this.idRtProductType = idRtProductType;
  }    
    
  public UUID getIdRtProductStatus() {
    return this.idRtProductStatus;
  }
    
  public UUID setIdRtProductStatus(UUID idRtProductStatus) {
    return this.idRtProductStatus = idRtProductStatus;
  }    
    
  public UUID getIdRtProductCategory() {
    return this.idRtProductCategory;
  }
    
  public UUID setIdRtProductCategory(UUID idRtProductCategory) {
    return this.idRtProductCategory = idRtProductCategory;
  }    
    
  public String getName() {
    return this.name;
  }
    
  public String setName(String name) {
    return this.name = name;
  }    
    
  public String getCode() {
    return this.code;
  }
    
  public String setCode(String code) {
    return this.code = code;
  }    
    
  public String getDescription() {
    return this.description;
  }
    
  public String setDescription(String description) {
    return this.description = description;
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