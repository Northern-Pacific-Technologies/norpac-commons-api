package com.norpactech.nc.api.model;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import com.norpactech.nc.model.BaseModel;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: ServiceOrder - Created service_order from Import
 */
public class ServiceOrder extends BaseModel {

  private UUID id;
  private UUID idTenant;
  private UUID idCustomer;
  private UUID idProduct;
  private UUID idSubscriptionPlan;
  private UUID idScheduleRule;
  private UUID idRtServiceStatus;
  private Integer quantity;
  private LocalDateTime serviceDate;
  private Double priceAtOrder;
  private UUID invoiceId;
  private Gson metadata;
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public ServiceOrder () {}
  public ServiceOrder (Object obj) {
    super(obj);
  }

  public ServiceOrder (
    UUID id,
    UUID idTenant,
    UUID idCustomer,
    UUID idProduct,
    UUID idSubscriptionPlan,
    UUID idScheduleRule,
    UUID idRtServiceStatus,
    Integer quantity,
    LocalDateTime serviceDate,
    Double priceAtOrder,
    UUID invoiceId,
    Gson metadata,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.id = id;
    this.idTenant = idTenant;
    this.idCustomer = idCustomer;
    this.idProduct = idProduct;
    this.idSubscriptionPlan = idSubscriptionPlan;
    this.idScheduleRule = idScheduleRule;
    this.idRtServiceStatus = idRtServiceStatus;
    this.quantity = quantity;
    this.serviceDate = serviceDate;
    this.priceAtOrder = priceAtOrder;
    this.invoiceId = invoiceId;
    this.metadata = metadata;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, ServiceOrder.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.service_order.* " + 
      "FROM norpac_commons.service_order");
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
    
  public UUID getIdCustomer() {
    return this.idCustomer;
  }
    
  public UUID setIdCustomer(UUID idCustomer) {
    return this.idCustomer = idCustomer;
  }    
    
  public UUID getIdProduct() {
    return this.idProduct;
  }
    
  public UUID setIdProduct(UUID idProduct) {
    return this.idProduct = idProduct;
  }    
    
  public UUID getIdSubscriptionPlan() {
    return this.idSubscriptionPlan;
  }
    
  public UUID setIdSubscriptionPlan(UUID idSubscriptionPlan) {
    return this.idSubscriptionPlan = idSubscriptionPlan;
  }    
    
  public UUID getIdScheduleRule() {
    return this.idScheduleRule;
  }
    
  public UUID setIdScheduleRule(UUID idScheduleRule) {
    return this.idScheduleRule = idScheduleRule;
  }    
    
  public UUID getIdRtServiceStatus() {
    return this.idRtServiceStatus;
  }
    
  public UUID setIdRtServiceStatus(UUID idRtServiceStatus) {
    return this.idRtServiceStatus = idRtServiceStatus;
  }    
    
  public Integer getQuantity() {
    return this.quantity;
  }
    
  public Integer setQuantity(Integer quantity) {
    return this.quantity = quantity;
  }    
    
  public LocalDateTime getServiceDate() {
    return this.serviceDate;
  }
    
  public LocalDateTime setServiceDate(LocalDateTime serviceDate) {
    return this.serviceDate = serviceDate;
  }    
    
  public Double getPriceAtOrder() {
    return this.priceAtOrder;
  }
    
  public Double setPriceAtOrder(Double priceAtOrder) {
    return this.priceAtOrder = priceAtOrder;
  }    
    
  public UUID getInvoiceId() {
    return this.invoiceId;
  }
    
  public UUID setInvoiceId(UUID invoiceId) {
    return this.invoiceId = invoiceId;
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