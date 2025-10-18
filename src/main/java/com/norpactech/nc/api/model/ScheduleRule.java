package com.norpactech.nc.api.model;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import com.norpactech.nc.model.BaseModel;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: ScheduleRule - Created schedule_rule from Import
 */
public class ScheduleRule extends BaseModel {

  private UUID id;
  private UUID idTenant;
  private UUID idProduct;
  private String scheduleName;
  private LocalDateTime startDate;
  private String recurrenceRule;
  private Integer durationMinutes;
  private String timezone;
  private Gson metadata;
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public ScheduleRule () {}
  public ScheduleRule (Object obj) {
    super(obj);
  }

  public ScheduleRule (
    UUID id,
    UUID idTenant,
    UUID idProduct,
    String scheduleName,
    LocalDateTime startDate,
    String recurrenceRule,
    Integer durationMinutes,
    String timezone,
    Gson metadata,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.id = id;
    this.idTenant = idTenant;
    this.idProduct = idProduct;
    this.scheduleName = scheduleName;
    this.startDate = startDate;
    this.recurrenceRule = recurrenceRule;
    this.durationMinutes = durationMinutes;
    this.timezone = timezone;
    this.metadata = metadata;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, ScheduleRule.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.schedule_rule.* " + 
      "FROM norpac_commons.schedule_rule");
    return matchedParams;
  }

  // Getters and Setters...
    
  public UUID getId() {
    return this.id;
  }
    
  public UUID setId(UUID id) {
    return this.id = id;
  }    
    
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
    
  public Timestamp getCreatedAt() {
    return this.createdAt;
  }
    
  public Timestamp setCreatedAt(Timestamp createdAt) {
    return this.createdAt = createdAt;
  }    
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
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
    
  public Boolean getIsActive() {
    return this.isActive;
  }
    
  public Boolean setIsActive(Boolean isActive) {
    return this.isActive = isActive;
  }    
}