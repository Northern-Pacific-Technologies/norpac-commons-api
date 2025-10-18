package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
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
 * Created bundle from Import
 */
public class BundlePutApiRequest {

  private UUID id;
  private UUID idRtBundleStrategy;
  private Double discountPercent;
  private Gson metadata;
  private Timestamp updatedAt;
  private String updatedBy;

  public BundlePutApiRequest () {}

  @Hidden
  public Map<String, Object> getUpdateRequest() {
    
     var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.u_bundle(?,?,?,?,?,?)");
    request.put("id", this.id);
    request.put("idRtBundleStrategy", this.idRtBundleStrategy);
    request.put("discountPercent", this.discountPercent);
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
    
  public UUID getIdRtBundleStrategy() {
    return this.idRtBundleStrategy;
  }
    
  public UUID setIdRtBundleStrategy(UUID idRtBundleStrategy) {
    return this.idRtBundleStrategy = idRtBundleStrategy;
  }    
    
  public Double getDiscountPercent() {
    return this.discountPercent;
  }
    
  public Double setDiscountPercent(Double discountPercent) {
    return this.discountPercent = discountPercent;
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