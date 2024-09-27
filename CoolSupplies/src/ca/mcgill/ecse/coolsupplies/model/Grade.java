/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package ca.mcgill.ecse.coolsupplies.model;
import java.util.*;

// line 32 "../../../../../CoolSupplies.ump"
// line 129 "../../../../../CoolSupplies.ump"
public class Grade
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Grade Attributes
  private String gradeNumber;

  //Grade Associations
  private List<Student> students;
  private Bundle bundle;
  private CoolSupplies coolSupplies;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Grade(String aGradeNumber, CoolSupplies aCoolSupplies)
  {
    gradeNumber = aGradeNumber;
    students = new ArrayList<Student>();
    boolean didAddCoolSupplies = setCoolSupplies(aCoolSupplies);
    if (!didAddCoolSupplies)
    {
      throw new RuntimeException("Unable to create grade due to coolSupplies. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setGradeNumber(String aGradeNumber)
  {
    boolean wasSet = false;
    gradeNumber = aGradeNumber;
    wasSet = true;
    return wasSet;
  }

  public String getGradeNumber()
  {
    return gradeNumber;
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

  public boolean hasBundle()
  {
    boolean has = bundle != null;
    return has;
  }
  /* Code from template association_GetOne */
  public CoolSupplies getCoolSupplies()
  {
    return coolSupplies;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStudents()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Student addStudent(String aName, int aId, String aDateOfBirth, CoolSupplies aCoolSupplies)
  {
    return new Student(aName, aId, aDateOfBirth, this, aCoolSupplies);
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
  /* Code from template association_SetOptionalOneToOne */
  public boolean setBundle(Bundle aNewBundle)
  {
    boolean wasSet = false;
    if (bundle != null && !bundle.equals(aNewBundle) && equals(bundle.getGrade()))
    {
      //Unable to setBundle, as existing bundle would become an orphan
      return wasSet;
    }

    bundle = aNewBundle;
    Grade anOldGrade = aNewBundle != null ? aNewBundle.getGrade() : null;

    if (!this.equals(anOldGrade))
    {
      if (anOldGrade != null)
      {
        anOldGrade.bundle = null;
      }
      if (bundle != null)
      {
        bundle.setGrade(this);
      }
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCoolSupplies(CoolSupplies aCoolSupplies)
  {
    boolean wasSet = false;
    if (aCoolSupplies == null)
    {
      return wasSet;
    }

    CoolSupplies existingCoolSupplies = coolSupplies;
    coolSupplies = aCoolSupplies;
    if (existingCoolSupplies != null && !existingCoolSupplies.equals(aCoolSupplies))
    {
      existingCoolSupplies.removeGrade(this);
    }
    coolSupplies.addGrade(this);
    wasSet = true;
    return wasSet;
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
    CoolSupplies placeholderCoolSupplies = coolSupplies;
    this.coolSupplies = null;
    if(placeholderCoolSupplies != null)
    {
      placeholderCoolSupplies.removeGrade(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "gradeNumber" + ":" + getGradeNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bundle = "+(getBundle()!=null?Integer.toHexString(System.identityHashCode(getBundle())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "coolSupplies = "+(getCoolSupplies()!=null?Integer.toHexString(System.identityHashCode(getCoolSupplies())):"null");
  }
}