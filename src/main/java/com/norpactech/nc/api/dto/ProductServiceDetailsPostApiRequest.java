package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created product_service_details from Import
 */
 public class ProductServiceDetailsPostApiRequest {

  private UUID idProduct;
  private Integer estimatedDurationMinutes;
  private Boolean requiresPressureWash;
  private String equipmentType;
  private Double baseDistanceKm;
  private Gson metadata;
  private String createdBy;

  public ProductServiceDetailsPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_product_service_details(?,?,?,?,?,?,?)");
    request.put("idProduct", this.idProduct);
    request.put("estimatedDurationMinutes", this.estimatedDurationMinutes);
    request.put("requiresPressureWash", this.requiresPressureWash);
    request.put("equipmentType", this.equipmentType);
    request.put("baseDistanceKm", this.baseDistanceKm);
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
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}