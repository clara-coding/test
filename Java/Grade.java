/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.34.0.7242.6b8819789 modeling language!*/


import java.util.*;

// line 29 "model.ump"
// line 107 "model.ump"
public class Grade
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Grade Attributes
  private string name;

  //Grade Associations
  private List<Student> students;
  private Bundle bundle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Grade(string aName, Bundle aBundle)
  {
    name = aName;
    students = new ArrayList<Student>();
    if (aBundle == null || aBundle.getGrade() != null)
    {
      throw new RuntimeException("Unable to create Grade due to aBundle. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    bundle = aBundle;
  }

  public Grade(string aName, float aDiscountForBundle, Item... allItemsForBundle)
  {
    name = aName;
    students = new ArrayList<Student>();
    bundle = new Bundle(aDiscountForBundle, this, allItemsForBundle);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(string aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public string getName()
  {
    return name;
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
  /* Code from template association_GetOne */
  public Bundle getBundle()
  {
    return bundle;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStudents()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Student addStudent(string aFirstName, string aLastName, int aId, string aBirthdate)
  {
    return new Student(aFirstName, aLastName, aId, aBirthdate, this);
  }

  public boolean addStudent(Student aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    Grade existingGrade = aStudent.getGrade();
    boolean isNewGrade = existingGrade != null && !this.equals(existingGrade);
    if (isNewGrade)
    {
      aStudent.setGrade(this);
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
    //Unable to remove aStudent, as it must always have a grade
    if (!this.equals(aStudent.getGrade()))
    {
      students.remove(aStudent);
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
    for(int i=students.size(); i > 0; i--)
    {
      Student aStudent = students.get(i - 1);
      aStudent.delete();
    }
    Bundle existingBundle = bundle;
    bundle = null;
    if (existingBundle != null)
    {
      existingBundle.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "name" + "=" + (getName() != null ? !getName().equals(this)  ? getName().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "bundle = "+(getBundle()!=null?Integer.toHexString(System.identityHashCode(getBundle())):"null");
  }
}