package com.assessment.users.model;

public class UserEmailPassword {
  public UserEmailPassword() {
    
  }
  public UserEmailPassword(String username, String oneTimePassword, String recoveryCode) {
    this.username = username;
    this.oneTimePassword = oneTimePassword;
    this.recoveryCode = recoveryCode;
  }

  private String username;
  private String oneTimePassword;
  

  private String recoveryCode;
  
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getOneTimePassword() {
    return oneTimePassword;
  }

  public void setOneTimePassword(String oneTimePassword) {
    this.oneTimePassword = oneTimePassword;
  }

  public String getRecoveryCode() {
    return recoveryCode;
  }

  public void setRecoveryCode(String recoveryCode) {
    this.recoveryCode = recoveryCode;
  }
}
