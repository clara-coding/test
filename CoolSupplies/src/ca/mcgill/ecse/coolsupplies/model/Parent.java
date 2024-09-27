/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package ca.mcgill.ecse.coolsupplies.model;
import java.util.*;

// line 10 "../../../../../CoolSupplies.ump"
// line 111 "../../../../../CoolSupplies.ump"
// line 200 "../../../../../CoolSupplies.ump"
public class Parent extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Parent Attributes
  private String parentName;
  private String phoneNumber;

  //Parent Associations
  private List<Student> students;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Parent(String aAccountName, String aPassword, CoolSupplies aCoolSupplies, String aParentName, String aPhoneNumber)
  {
    super(aAccountName, aPassword, aCoolSupplies);
    parentName = aParentName;
    phoneNumber = aPhoneNumber;
    students = new ArrayList<Student>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setParentName(String aParentName)
  {
    boolean wasSet = false;
    parentName = aParentName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNumber(String aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public String getParentName()
  {
    return parentName;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }
  /* Code from template association_GetMany */
  public Student getStudent(int index)
  {
    Student aStudent = students.get(index);
    return aStudent;
  }

  public List<Student> getStudents()
  {
    List<Student> newStudents = Collections.unmodifiableList(students);
    return newStudents;
  }

  public int numberOfStudents()
  {
    int number = students.size();
    return number;
  }

  public boolean hasStudents()
  {
    boolean has = students.size() > 0;
    return has;
  }

  public int indexOfStudent(Student aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStudents()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addStudent(Student aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    Parent existingParent = aStudent.getParent();
    if (existingParent == null)
    {
      aStudent.setParent(this);
    }
    else if (!this.equals(existingParent))
    {
      existingParent.removeStudent(aStudent);
      addStudent(aStudent);
    }
    else
    {
      students.add(aStudent);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStudent(Student aStudent)
  {
    boolean wasRemoved = false;
    if (students.contains(aStudent))
    {
      students.remove(aStudent);
      aStudent.setParent(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStudentAt(Student aStudent, int index)
  {  
    boolean wasAdded = false;
    if(addStudent(aStudent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudents()) { index = numberOfStudents() - 1; }
      students.remove(aStudent);
      students.add(index, aStudent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStudentAt(Student aStudent, int index)
  {
    boolean wasAdded = false;
    if(students.contains(aStudent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudents()) { index = numberOfStudents() - 1; }
      students.remove(aStudent);
      students.add(index, aStudent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStudentAt(aStudent, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !students.isEmpty() )
    {
      students.get(0).setParent(null);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "parentName" + ":" + getParentName()+ "," +
            "phoneNumber" + ":" + getPhoneNumber()+ "]";
  }
}