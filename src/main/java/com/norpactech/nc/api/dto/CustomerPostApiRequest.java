package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.lang.String;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Post API Request
 * 
 * Created customer from Import
 */
 public class CustomerPostApiRequest {

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
  private String createdBy;

  public CustomerPostApiRequest () {}

  @Hidden
  public Map<String, Object> getInsertRequest() {
    
    var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.i_customer(?,?,?,?,?,?,?,?,?,?,?)");
    request.put("idTenant", this.idTenant);
    request.put("customerId", this.customerId);
    request.put("businessName", this.businessName);
    request.put("firstName", this.firstName);
    request.put("lastName", this.lastName);
    request.put("email", this.email);
    request.put("phoneNumber", this.phoneNumber);
    request.put("preferredContact", this.preferredContact);
    request.put("dateOfBirth", this.dateOfBirth);
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
    
  public String getCreatedBy() {
    return this.createdBy;
  }
    
  public String setCreatedBy(String createdBy) {
    return this.createdBy = createdBy;
  }    
}