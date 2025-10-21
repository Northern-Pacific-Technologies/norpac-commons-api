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
 * Created product_category from Import
 */
 public class ProductCategoryPostApiRequest {

  private UUID idTenant;
  private UUID idParentCategory;
  private String code;
  private String name;
  private String description;
  private String createdBy;

  public ProductCategoryPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_product_category(?,?,?,?,?,?)");
    request.put("idTenant", this.idTenant);
    request.put("idParentCategory", this.idParentCategory);
    request.put("code", this.code);
    request.put("name", this.name);
    request.put("description", this.description);
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
    
  public UUID getIdParentCategory() {
    return this.idParentCategory;
  }
    
  public UUID setIdParentCategory(UUID idParentCategory) {
    return this.idParentCategory = idParentCategory;
  }    
    
  public String getCode() {
    return this.code;
  }
    
  public String setCode(String code) {
    return this.code = code;
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
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}