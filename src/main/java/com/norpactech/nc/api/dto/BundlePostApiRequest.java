package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import java.lang.Double;
import java.lang.String;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created bundle from Import
 */
 public class BundlePostApiRequest {

  private UUID idTenant;
  private UUID idRtBundleStrategy;
  private Double discountPercent;
  private Gson metadata;
  private String createdBy;

  public BundlePostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_bundle(?,?,?,?,?)");
    request.put("idTenant", this.idTenant);
    request.put("idRtBundleStrategy", this.idRtBundleStrategy);
    request.put("discountPercent", this.discountPercent);
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
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}