package com.assessment.users.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Document(collection = "users")
public class UserInfo {
  
  @Id
  private String id;
  private String email;
  private String firstName;
  private String lastName;
  private String location;
  private String department;
  private String username;
  @JsonProperty(access = Access.WRITE_ONLY)
  private String oneTimePassword;
  private String recoveryCode;
  
  public UserInfo() {
  }
  
  public UserInfo(String id, String username, String firstName, String lastName, String department, String location, String oneTimePassword, String recoveryCode, String email) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.department = department;
    this.location = location;
    this.oneTimePassword = oneTimePassword;
    this.recoveryCode = recoveryCode;
    this.email = email;
  }
  
  public UserInfo(String id, String username, String firstName, String lastName, String department, String location, String oneTimePassword, String recoveryCode) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.department = department;
    this.location = location;
    this.oneTimePassword = oneTimePassword;
    this.recoveryCode = recoveryCode;
  }

  public UserInfo(String id, String email, String firstName, String lastName) {
    this.id = id;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  public String getOneTimePassword() {
    return oneTimePassword;
  }

  @JsonIgnore
  public void setOneTimePassword(String oneTimePassword) {
    this.oneTimePassword = oneTimePassword;
  }

  @JsonIgnore
  public String getRecoveryCode() {
    return recoveryCode;
  }

  public void setRecoveryCode(String recoveryCode) {
    this.recoveryCode = recoveryCode;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
