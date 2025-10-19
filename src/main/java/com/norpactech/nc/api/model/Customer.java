package com.norpactech.nc.api.model;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import com.norpactech.nc.model.BaseModel;
import java.lang.Boolean;
import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

/**
 * API Model Class: Customer - Created customer from Import
 */
public class Customer extends BaseModel {

  private UUID id;
  private UUID idTenant;
  private String customerId;
  private String businessName;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String preferredContact;
  private LocalDate dateOfBirth;
  private String description;
  private Timestamp createdAt;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Boolean isActive;

  public Customer () {}
  public Customer (Object obj) {
    super(obj);
  }

  public Customer (
    UUID id,
    UUID idTenant,
    String customerId,
    String businessName,
    String firstName,
    String lastName,
    String email,
    String phoneNumber,
    String preferredContact,
    LocalDate dateOfBirth,
    String description,
    Timestamp createdAt,
    String createdBy,
    Timestamp updatedAt,
    String updatedBy,
    Boolean isActive)
 {
    this.id = id;
    this.idTenant = idTenant;
    this.customerId = customerId;
    this.businessName = businessName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.preferredContact = preferredContact;
    this.dateOfBirth = dateOfBirth;
    this.description = description;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.isActive = isActive;
  }

  public static Map<String, Object> queryRequest(Map<String, String> queryParams) throws Exception {
    
    var matchedParams = paramMatcher(queryParams, Customer.class);
    matchedParams.put("sql", 
      "SELECT norpac_commons.customer.* " + 
      "FROM norpac_commons.customer");
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
    
  public String getCustomerId() {
    return this.customerId;
  }
    
  public String setCustomerId(String customerId) {
    return this.customerId = customerId;
  }    
    
  public String getBusinessName() {
    return this.businessName;
  }
    
  public String setBusinessName(String businessName) {
    return this.businessName = businessName;
  }    
    
  public String getFirstName() {
    return this.firstName;
  }
    
  public String setFirstName(String firstName) {
    return this.firstName = firstName;
  }    
    
  public String getLastName() {
    return this.lastName;
  }
    
  public String setLastName(String lastName) {
    return this.lastName = lastName;
  }    
    
  public String getEmail() {
    return this.email;
  }
    
  public String setEmail(String email) {
    return this.email = email;
  }    
    
  public String getPhoneNumber() {
    return this.phoneNumber;
  }
    
  public String setPhoneNumber(String phoneNumber) {
    return this.phoneNumber = phoneNumber;
  }    
    
  public String getPreferredContact() {
    return this.preferredContact;
  }
    
  public String setPreferredContact(String preferredContact) {
    return this.preferredContact = preferredContact;
  }    
    
  public LocalDate getDateOfBirth() {
    return this.dateOfBirth;
  }
    
  public LocalDate setDateOfBirth(LocalDate dateOfBirth) {
    return this.dateOfBirth = dateOfBirth;
  }    
    
  public String getDescription() {
    return this.description;
  }
    
  public String setDescription(String description) {
    return this.description = description;
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