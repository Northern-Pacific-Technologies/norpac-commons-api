package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import java.lang.Integer;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created schedule_rule from Import
 */
 public class ScheduleRulePostApiRequest {

  private UUID idTenant;
  private UUID idProduct;
  private String scheduleName;
  private LocalDateTime startDate;
  private String recurrenceRule;
  private Integer durationMinutes;
  private String timezone;
  private Gson metadata;
  private String createdBy;

  public ScheduleRulePostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_schedule_rule(?,?,?,?,?,?,?,?,?)");
    request.put("idTenant", this.idTenant);
    request.put("idProduct", this.idProduct);
    request.put("scheduleName", this.scheduleName);
    request.put("startDate", this.startDate);
    request.put("recurrenceRule", this.recurrenceRule);
    request.put("durationMinutes", this.durationMinutes);
    request.put("timezone", this.timezone);
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
    
  public UUID getIdProduct() {
    return this.idProduct;
  }
    
  public UUID setIdProduct(UUID idProduct) {
    return this.idProduct = idProduct;
  }    
    
  public String getScheduleName() {
    return this.scheduleName;
  }
    
  public String setScheduleName(String scheduleName) {
    return this.scheduleName = scheduleName;
  }    
    
  public LocalDateTime getStartDate() {
    return this.startDate;
  }
    
  public LocalDateTime setStartDate(LocalDateTime startDate) {
    return this.startDate = startDate;
  }    
    
  public String getRecurrenceRule() {
    return this.recurrenceRule;
  }
    
  public String setRecurrenceRule(String recurrenceRule) {
    return this.recurrenceRule = recurrenceRule;
  }    
    
  public Integer getDurationMinutes() {
    return this.durationMinutes;
  }
    
  public Integer setDurationMinutes(Integer durationMinutes) {
    return this.durationMinutes = durationMinutes;
  }    
    
  public String getTimezone() {
    return this.timezone;
  }
    
  public String setTimezone(String timezone) {
    return this.timezone = timezone;
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