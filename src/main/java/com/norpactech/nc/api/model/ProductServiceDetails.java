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
import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: ProductServiceDetails - Created product_service_details from Import
 */
public class ProductServiceDetails extends BaseModel {

  private UUID idProduct;
  private Integer estimatedDurationMinutes;
  private Boolean requiresPressureWash;
  private String equipmentType;
  private Double baseDistanceKm;
  private Gson metadata;
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public ProductServiceDetails () {}
  public ProductServiceDetails (Object obj) {
    super(obj);
  }

  public ProductServiceDetails (
    UUID idProduct,
    Integer estimatedDurationMinutes,
    Boolean requiresPressureWash,
    String equipmentType,
    Double baseDistanceKm,
    Gson metadata,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.idProduct = idProduct;
    this.estimatedDurationMinutes = estimatedDurationMinutes;
    this.requiresPressureWash = requiresPressureWash;
    this.equipmentType = equipmentType;
    this.baseDistanceKm = baseDistanceKm;
    this.metadata = metadata;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, ProductServiceDetails.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.product_service_details.* " + 
      "FROM norpac_commons.product_service_details");
    return matchedParams;
  }

  // Getters and Setters...
    
  public UUID getIdProduct() {
    return this.idProduct;
  }
    
  public UUID setIdProduct(UUID idProduct) {
    return this.idProduct = idProduct;
  }    
    
  public Integer getEstimatedDurationMinutes() {
    return this.estimatedDurationMinutes;
  }
    
  public Integer setEstimatedDurationMinutes(Integer estimatedDurationMinutes) {
    return this.estimatedDurationMinutes = estimatedDurationMinutes;
  }    
    
  public Boolean getRequiresPressureWash() {
    return this.requiresPressureWash;
  }
    
  public Boolean setRequiresPressureWash(Boolean requiresPressureWash) {
    return this.requiresPressureWash = requiresPressureWash;
  }    
    
  public String getEquipmentType() {
    return this.equipmentType;
  }
    
  public String setEquipmentType(String equipmentType) {
    return this.equipmentType = equipmentType;
  }    
    
  public Double getBaseDistanceKm() {
    return this.baseDistanceKm;
  }
    
  public Double setBaseDistanceKm(Double baseDistanceKm) {
    return this.baseDistanceKm = baseDistanceKm;
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