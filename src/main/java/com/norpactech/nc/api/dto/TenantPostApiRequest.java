package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.lang.String;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created tenant from Import
 */
 public class TenantPostApiRequest {

  private UUID idRtOrigin;
  private String name;
  private String createdBy;

  public TenantPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_tenant(?,?,?)");
    request.put("idRtOrigin", this.idRtOrigin);
    request.put("name", this.name);
    request.put("createdBy", this.createdBy);
    return request;
  }
  
  // Getters and Setters...
    
  public UUID getIdRtOrigin() {
    return this.idRtOrigin;
  }
    
  public UUID setIdRtOrigin(UUID idRtOrigin) {
    return this.idRtOrigin = idRtOrigin;
  }    
    
  public String getName() {
    return this.name;
  }
    
  public String setName(String name) {
    return this.name = name;
  }    
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}