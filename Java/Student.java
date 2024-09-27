/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.34.0.7242.6b8819789 modeling language!*/


import java.util.*;

// line 21 "model.ump"
// line 102 "model.ump"
public class Student
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Student Attributes
  private string firstName;
  private string lastName;
  private int id;
  private string birthdate;

  //Student Associations
  private Parent parent;
  private Grade grade;
  private List<Order> orders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Student(string aFirstName, string aLastName, int aId, string aBirthdate, Grade aGrade)
  {
    firstName = aFirstName;
    lastName = aLastName;
    id = aId;
    birthdate = aBirthdate;
    boolean didAddGrade = setGrade(aGrade);
    if (!didAddGrade)
    {
      throw new RuntimeException("Unable to create student due to grade. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    orders = new ArrayList<Order>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFirstName(string aFirstName)
  {
    boolean wasSet = false;
    firstName = aFirstName;
    wasSet = true;
    return wasSet;
  }

  public boolean setLastName(string aLastName)
  {
    boolean wasSet = false;
    lastName = aLastName;
    wasSet = true;
    return wasSet;
  }

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setBirthdate(string aBirthdate)
  {
    boolean wasSet = false;
    birthdate = aBirthdate;
    wasSet = true;
    return wasSet;
  }

  public string getFirstName()
  {
    return firstName;
  }

  public string getLastName()
  {
    return lastName;
  }

  public int getId()
  {
    return id;
  }

  public string getBirthdate()
  {
    return birthdate;
  }
  /* Code from template association_GetOne */
  public Parent getParent()
  {
    return parent;
  }

  public boolean hasParent()
  {
    boolean has = parent != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Grade getGrade()
  {
    return grade;
  }
  /* Code from template association_GetMany */
  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setParent(Parent aParent)
  {
    boolean wasSet = false;
    Parent existingParent = parent;
    parent = aParent;
    if (existingParent != null && !existingParent.equals(aParent))
    {
      existingParent.removeStudent(this);
    }
    if (aParent != null)
    {
      aParent.addStudent(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setGrade(Grade aGrade)
  {
    boolean wasSet = false;
    if (aGrade == null)
    {
      return wasSet;
    }

    Grade existingGrade = grade;
    grade = aGrade;
    if (existingGrade != null && !existingGrade.equals(aGrade))
    {
      existingGrade.removeStudent(this);
    }
    grade.addStudent(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addOrder(string aDate, int aOrderNumber, boolean aPickedUp)
  {
    return new Order(aDate, aOrderNumber, aPickedUp, this);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Student existingStudent = aOrder.getStudent();
    boolean isNewStudent = existingStudent != null && !this.equals(existingStudent);
    if (isNewStudent)
    {
      aOrder.setStudent(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a student
    if (!this.equals(aOrder.getStudent()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    if (parent != null)
    {
      Parent placeholderParent = parent;
      this.parent = null;
      placeholderParent.removeStudent(this);
    }
    Grade placeholderGrade = grade;
    this.grade = null;
    if(placeholderGrade != null)
    {
      placeholderGrade.removeStudent(this);
    }
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "firstName" + "=" + (getFirstName() != null ? !getFirstName().equals(this)  ? getFirstName().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "lastName" + "=" + (getLastName() != null ? !getLastName().equals(this)  ? getLastName().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "birthdate" + "=" + (getBirthdate() != null ? !getBirthdate().equals(this)  ? getBirthdate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "parent = "+(getParent()!=null?Integer.toHexString(System.identityHashCode(getParent())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "grade = "+(getGrade()!=null?Integer.toHexString(System.identityHashCode(getGrade())):"null");
  }
}