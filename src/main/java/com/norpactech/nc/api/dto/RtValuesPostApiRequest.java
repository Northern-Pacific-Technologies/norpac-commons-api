package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created rt_values from Import
 */
 public class RtValuesPostApiRequest {

  private UUID idTenant;
  private UUID idRtType;
  private Integer sequence;
  private String name;
  private String description;
  private String value;
  private String createdBy;

  public RtValuesPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_rt_values(?,?,?,?,?,?,?)");
    request.put("idTenant", this.idTenant);
    request.put("idRtType", this.idRtType);
    request.put("sequence", this.sequence);
    request.put("name", this.name);
    request.put("description", this.description);
    request.put("value", this.value);
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
    
  public UUID getIdRtType() {
    return this.idRtType;
  }
    
  public UUID setIdRtType(UUID idRtType) {
    return this.idRtType = idRtType;
  }    
    
  public Integer getSequence() {
    return this.sequence;
  }
    
  public Integer setSequence(Integer sequence) {
    return this.sequence = sequence;
  }    
    
  public String getName() {
    return this.name;
  }
    
  public String setName(String name) {
    return this.name = name;
  }    
    
  public String getDescription() {
    return this.description;
  }
    
  public String setDescription(String description) {
    return this.description = description;
  }    
    
  public String getValue() {
    return this.value;
  }
    
  public String setValue(String value) {
    return this.value = value;
  }    
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}