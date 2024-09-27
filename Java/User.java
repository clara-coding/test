/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.34.0.7242.6b8819789 modeling language!*/



// line 2 "model.ump"
// line 85 "model.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private string accountName;
  private string password;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(string aAccountName, string aPassword)
  {
    accountName = aAccountName;
    password = aPassword;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAccountName(string aAccountName)
  {
    boolean wasSet = false;
    accountName = aAccountName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(string aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public string getAccountName()
  {
    return accountName;
  }

  public string getPassword()
  {
    return password;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "accountName" + "=" + (getAccountName() != null ? !getAccountName().equals(this)  ? getAccountName().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "password" + "=" + (getPassword() != null ? !getPassword().equals(this)  ? getPassword().toString().replaceAll("  ","    ") : "this" : "null");
  }
}