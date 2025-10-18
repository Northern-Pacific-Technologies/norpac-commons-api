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
import java.sql.Timestamp;
import java.util.Map;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Put API Request
 * 
 * Created product_service_details from Import
 */
public class ProductServiceDetailsPutApiRequest {

  private Integer estimatedDurationMinutes;
  private Boolean requiresPressureWash;
  private String equipmentType;
  private Double baseDistanceKm;
  private Gson metadata;
  private Timestamp updatedAt;
  private String updatedBy;

  public ProductServiceDetailsPutApiRequest () {}

  @Hidden
  public Map<String, Object> getUpdateRequest() {
    
     var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.u_product_service_details(?,?,?,?,?,?,?)");
    request.put("estimatedDurationMinutes", this.estimatedDurationMinutes);
    request.put("requiresPressureWash", this.requiresPressureWash);
    request.put("equipmentType", this.equipmentType);
    request.put("baseDistanceKm", this.baseDistanceKm);
    request.put("metadata", this.metadata);
    request.put("updatedAt", this.updatedAt);
    request.put("updatedBy", this.updatedBy);
    return request;
  }
  
  // Getters and Setters...
    
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