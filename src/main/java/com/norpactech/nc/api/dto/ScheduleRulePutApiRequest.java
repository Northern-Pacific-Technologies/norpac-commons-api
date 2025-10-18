package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Put API Request
 * 
 * Created schedule_rule from Import
 */
public class ScheduleRulePutApiRequest {

  private UUID id;
  private UUID idProduct;
  private String scheduleName;
  private LocalDateTime startDate;
  private String recurrenceRule;
  private Integer durationMinutes;
  private String timezone;
  private Gson metadata;
  private Timestamp updatedAt;
  private String updatedBy;

  public ScheduleRulePutApiRequest () {}

  @Hidden
  public Map<String, Object> getUpdateRequest() {
    
     var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.u_schedule_rule(?,?,?,?,?,?,?,?,?,?)");
    request.put("id", this.id);
    request.put("idProduct", this.idProduct);
    request.put("scheduleName", this.scheduleName);
    request.put("startDate", this.startDate);
    request.put("recurrenceRule", this.recurrenceRule);
    request.put("durationMinutes", this.durationMinutes);
    request.put("timezone", this.timezone);
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