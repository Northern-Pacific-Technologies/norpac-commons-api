package com.norpactech.nc.api.dto;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;
import java.util.LinkedHashMap;
import io.swagger.v3.oas.annotations.Hidden;

/**
 * Put API Request
 * 
 * Created customer from Import
 */
public class CustomerPutApiRequest {

  private UUID id;
  private String customerId;
  private String businessName;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String preferredContact;
  private LocalDate dateOfBirth;
  private String description;
  private Timestamp updatedAt;
  private String updatedBy;

  public CustomerPutApiRequest () {}

  @Hidden
  public Map<String, Object> getUpdateRequest() {
    
     var request = new LinkedHashMap<String, Object>();
    request.put("sql", "SELECT norpac_commons.u_customer(?,?,?,?,?,?,?,?,?,?,?,?)");
    request.put("id", this.id);
    request.put("customerId", this.customerId);
    request.put("businessName", this.businessName);
    request.put("firstName", this.firstName);
    request.put("lastName", this.lastName);
    request.put("email", this.email);
    request.put("phoneNumber", this.phoneNumber);
    request.put("preferredContact", this.preferredContact);
    request.put("dateOfBirth", this.dateOfBirth);
    request.put("description", this.description);
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