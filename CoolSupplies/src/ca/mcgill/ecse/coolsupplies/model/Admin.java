/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package ca.mcgill.ecse.coolsupplies.model;
import java.util.*;

// line 18 "../../../../../CoolSupplies.ump"
// line 118 "../../../../../CoolSupplies.ump"
public class Admin extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Admin Attributes
  private String accountName;
  private String password;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Admin(String aAccountName, String aPassword, CoolSupplies aCoolSupplies)
  {
    super(aAccountName, aPassword, aCoolSupplies);
    accountName = "admin@cool.ca";
    password = "admin";
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public String getAccountName()
  {
    return accountName;
  }

  public String getPassword()
  {
    return password;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "accountName" + ":" + getAccountName()+ "," +
            "password" + ":" + getPassword()+ "]";
  }
}