/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.34.0.7242.6b8819789 modeling language!*/


import java.util.*;

// line 8 "model.ump"
// line 90 "model.ump"
public class Parent extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Parent Attributes
  private string parentName;
  private string phoneNumber;

  //Parent Associations
  private List<Student> students;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Parent(string aAccountName, string aPassword, string aParentName, string aPhoneNumber)
  {
    super(aAccountName, aPassword);
    parentName = aParentName;
    phoneNumber = aPhoneNumber;
    students = new ArrayList<Student>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setParentName(string aParentName)
  {
    boolean wasSet = false;
    parentName = aParentName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNumber(string aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public string getParentName()
  {
    return parentName;
  }

  public string getPhoneNumber()
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
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "parentName" + "=" + (getParentName() != null ? !getParentName().equals(this)  ? getParentName().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "phoneNumber" + "=" + (getPhoneNumber() != null ? !getPhoneNumber().equals(this)  ? getPhoneNumber().toString().replaceAll("  ","    ") : "this" : "null");
  }
}