package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import java.lang.String;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Put API Request
 * 
 * Created product from Import
 */
public class ProductPutApiRequest {

  private UUID id;
  private UUID idRtProductType;
  private UUID idRtProductStatus;
  private UUID idRtProductCategory;
  private String name;
  private String code;
  private String description;
  private Gson metadata;
  private Timestamp updatedAt;
  private String updatedBy;

  public ProductPutApiRequest () {}

  @Hidden
  public Map<String, Object> getUpdateRequest() {
    
     var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.u_product(?,?,?,?,?,?,?,?,?,?)");
    request.put("id", this.id);
    request.put("idRtProductType", this.idRtProductType);
    request.put("idRtProductStatus", this.idRtProductStatus);
    request.put("idRtProductCategory", this.idRtProductCategory);
    request.put("name", this.name);
    request.put("code", this.code);
    request.put("description", this.description);
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