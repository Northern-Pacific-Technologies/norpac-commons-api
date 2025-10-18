package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.google.gson.Gson;
import java.lang.Double;
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
 * Created service_order from Import
 */
public class ServiceOrderPutApiRequest {

  private UUID id;
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
  private Timestamp updatedAt;
  private String updatedBy;

  public ServiceOrderPutApiRequest () {}

  @Hidden
  public Map<String, Object> getUpdateRequest() {
    
     var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.u_service_order(?,?,?,?,?,?,?,?,?,?,?,?,?)");
    request.put("id", this.id);
    request.put("idCustomer", this.idCustomer);
    request.put("idProduct", this.idProduct);
    request.put("idSubscriptionPlan", this.idSubscriptionPlan);
    request.put("idScheduleRule", this.idScheduleRule);
    request.put("idRtServiceStatus", this.idRtServiceStatus);
    request.put("quantity", this.quantity);
    request.put("serviceDate", this.serviceDate);
    request.put("priceAtOrder", this.priceAtOrder);
    request.put("invoiceId", this.invoiceId);
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