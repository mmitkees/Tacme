package com.tacme.pp.model.common.beans;

import java.io.Serializable;
import java.util.Date;

public class UserBean
  implements Serializable
{
  private String userName;
  private String email;
  private String password;
  private String emiratesId;
  private String emiratesIdExpiry;
  private String firstName;
  private String lastName;
  private String fullName;
  private String dateOfBirthAsString;
  private Date dateOfBirthAsDate;
  private String mobileNumber;
  private String status;
  private String nationality;
  private String occupation;
  private String preferedLocale;
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setEmiratesId(String emiratesId)
  {
    this.emiratesId = emiratesId;
  }
  
  public String getEmiratesId()
  {
    return this.emiratesId;
  }
  
  public void setEmiratesIdExpiry(String emiratesIdExpiry)
  {
    this.emiratesIdExpiry = emiratesIdExpiry;
  }
  
  public String getEmiratesIdExpiry()
  {
    return this.emiratesIdExpiry;
  }
  
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  
  public String getFirstName()
  {
    return this.firstName;
  }
  
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
  
  public String getLastName()
  {
    return this.lastName;
  }
  
  public void setFullName(String fullName)
  {
    this.fullName = fullName;
  }
  
  public String getFullName()
  {
    return this.fullName;
  }
  
  public void setMobileNumber(String mobileNumber)
  {
    this.mobileNumber = mobileNumber;
  }
  
  public String getMobileNumber()
  {
    return this.mobileNumber;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setNationality(String nationality)
  {
    this.nationality = nationality;
  }
  
  public String getNationality()
  {
    return this.nationality;
  }
  
  public void setOccupation(String occupation)
  {
    this.occupation = occupation;
  }
  
  public String getOccupation()
  {
    return this.occupation;
  }
  
  public void setPreferedLocale(String preferedLocale)
  {
    this.preferedLocale = preferedLocale;
  }
  
  public String getPreferedLocale()
  {
    return this.preferedLocale;
  }
  
  public void setDateOfBirthAsString(String dateOfBirthAsString)
  {
    this.dateOfBirthAsString = dateOfBirthAsString;
  }
  
  public String getDateOfBirthAsString()
  {
    return this.dateOfBirthAsString;
  }
  
  public void setDateOfBirthAsDate(Date dateOfBirthAsDate)
  {
    this.dateOfBirthAsDate = dateOfBirthAsDate;
  }
  
  public Date getDateOfBirthAsDate()
  {
    return this.dateOfBirthAsDate;
  }
}
