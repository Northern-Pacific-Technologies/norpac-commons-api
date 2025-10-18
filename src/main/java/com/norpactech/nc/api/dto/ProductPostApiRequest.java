package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import java.lang.String;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created product from Import
 */
 public class ProductPostApiRequest {

  private UUID idTenant;
  private UUID idRtProductType;
  private UUID idRtProductStatus;
  private UUID idRtProductCategory;
  private String name;
  private String code;
  private String description;
  private Gson metadata;
  private String createdBy;

  public ProductPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_product(?,?,?,?,?,?,?,?,?)");
    request.put("idTenant", this.idTenant);
    request.put("idRtProductType", this.idRtProductType);
    request.put("idRtProductStatus", this.idRtProductStatus);
    request.put("idRtProductCategory", this.idRtProductCategory);
    request.put("name", this.name);
    request.put("code", this.code);
    request.put("description", this.description);
    request.put("metadata", this.metadata);
    request.put("createdBy", this.createdBy);
    return request;
  }
  
  // Getters and Setters...
    
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
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}