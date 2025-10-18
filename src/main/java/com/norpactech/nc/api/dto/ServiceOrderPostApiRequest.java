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
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created service_order from Import
 */
 public class ServiceOrderPostApiRequest {

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
  private String createdBy;

  public ServiceOrderPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_service_order(?,?,?,?,?,?,?,?,?,?,?,?)");
    request.put("idTenant", this.idTenant);
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
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}