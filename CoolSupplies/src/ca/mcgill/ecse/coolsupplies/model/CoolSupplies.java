/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package ca.mcgill.ecse.coolsupplies.model;
import java.util.*;

// line 93 "../../../../../CoolSupplies.ump"
// line 187 "../../../../../CoolSupplies.ump"
public class CoolSupplies
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CoolSupplies Attributes
  private String startOfSchoolYear;

  //CoolSupplies Associations
  private List<User> users;
  private List<Student> students;
  private List<Bundle> bundles;
  private List<Item> items;
  private List<Order> orders;
  private List<ItemPack> itemPacks;
  private List<Repetition> repetitions;
  private List<Grade> grades;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CoolSupplies(String aStartOfSchoolYear)
  {
    startOfSchoolYear = aStartOfSchoolYear;
    users = new ArrayList<User>();
    students = new ArrayList<Student>();
    bundles = new ArrayList<Bundle>();
    items = new ArrayList<Item>();
    orders = new ArrayList<Order>();
    itemPacks = new ArrayList<ItemPack>();
    repetitions = new ArrayList<Repetition>();
    grades = new ArrayList<Grade>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartOfSchoolYear(String aStartOfSchoolYear)
  {
    boolean wasSet = false;
    startOfSchoolYear = aStartOfSchoolYear;
    wasSet = true;
    return wasSet;
  }

  public String getStartOfSchoolYear()
  {
    return startOfSchoolYear;
  }
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
    return index;
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
  /* Code from template association_GetMany */
  public Bundle getBundle(int index)
  {
    Bundle aBundle = bundles.get(index);
    return aBundle;
  }

  public List<Bundle> getBundles()
  {
    List<Bundle> newBundles = Collections.unmodifiableList(bundles);
    return newBundles;
  }

  public int numberOfBundles()
  {
    int number = bundles.size();
    return number;
  }

  public boolean hasBundles()
  {
    boolean has = bundles.size() > 0;
    return has;
  }

  public int indexOfBundle(Bundle aBundle)
  {
    int index = bundles.indexOf(aBundle);
    return index;
  }
  /* Code from template association_GetMany */
  public Item getItem(int index)
  {
    Item aItem = items.get(index);
    return aItem;
  }

  public List<Item> getItems()
  {
    List<Item> newItems = Collections.unmodifiableList(items);
    return newItems;
  }

  public int numberOfItems()
  {
    int number = items.size();
    return number;
  }

  public boolean hasItems()
  {
    boolean has = items.size() > 0;
    return has;
  }

  public int indexOfItem(Item aItem)
  {
    int index = items.indexOf(aItem);
    return index;
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
  /* Code from template association_GetMany */
  public ItemPack getItemPack(int index)
  {
    ItemPack aItemPack = itemPacks.get(index);
    return aItemPack;
  }

  public List<ItemPack> getItemPacks()
  {
    List<ItemPack> newItemPacks = Collections.unmodifiableList(itemPacks);
    return newItemPacks;
  }

  public int numberOfItemPacks()
  {
    int number = itemPacks.size();
    return number;
  }

  public boolean hasItemPacks()
  {
    boolean has = itemPacks.size() > 0;
    return has;
  }

  public int indexOfItemPack(ItemPack aItemPack)
  {
    int index = itemPacks.indexOf(aItemPack);
    return index;
  }
  /* Code from template association_GetMany */
  public Repetition getRepetition(int index)
  {
    Repetition aRepetition = repetitions.get(index);
    return aRepetition;
  }

  public List<Repetition> getRepetitions()
  {
    List<Repetition> newRepetitions = Collections.unmodifiableList(repetitions);
    return newRepetitions;
  }

  public int numberOfRepetitions()
  {
    int number = repetitions.size();
    return number;
  }

  public boolean hasRepetitions()
  {
    boolean has = repetitions.size() > 0;
    return has;
  }

  public int indexOfRepetition(Repetition aRepetition)
  {
    int index = repetitions.indexOf(aRepetition);
    return index;
  }
  /* Code from template association_GetMany */
  public Grade getGrade(int index)
  {
    Grade aGrade = grades.get(index);
    return aGrade;
  }

  public List<Grade> getGrades()
  {
    List<Grade> newGrades = Collections.unmodifiableList(grades);
    return newGrades;
  }

  public int numberOfGrades()
  {
    int number = grades.size();
    return number;
  }

  public boolean hasGrades()
  {
    boolean has = grades.size() > 0;
    return has;
  }

  public int indexOfGrade(Grade aGrade)
  {
    int index = grades.indexOf(aGrade);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */


  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    CoolSupplies existingCoolSupplies = aUser.getCoolSupplies();
    boolean isNewCoolSupplies = existingCoolSupplies != null && !this.equals(existingCoolSupplies);
    if (isNewCoolSupplies)
    {
      aUser.setCoolSupplies(this);
    }
    else
    {
      users.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    //Unable to remove aUser, as it must always have a coolSupplies
    if (!this.equals(aUser.getCoolSupplies()))
    {
      users.remove(aUser);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStudents()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Student addStudent(String aName, int aId, String aDateOfBirth, Grade aGrade)
  {
    return new Student(aName, aId, aDateOfBirth, aGrade, this);
  }

  public boolean addStudent(Student aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    CoolSupplies existingCoolSupplies = aStudent.getCoolSupplies();
    boolean isNewCoolSupplies = existingCoolSupplies != null && !this.equals(existingCoolSupplies);
    if (isNewCoolSupplies)
    {
      aStudent.setCoolSupplies(this);
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
    //Unable to remove aStudent, as it must always have a coolSupplies
    if (!this.equals(aStudent.getCoolSupplies()))
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBundles()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Bundle addBundle(float aDiscountPercentage, Grade aGrade, Item... allItems)
  {
    return new Bundle(aDiscountPercentage, aGrade, this, allItems);
  }

  public boolean addBundle(Bundle aBundle)
  {
    boolean wasAdded = false;
    if (bundles.contains(aBundle)) { return false; }
    CoolSupplies existingCoolSupplies = aBundle.getCoolSupplies();
    boolean isNewCoolSupplies = existingCoolSupplies != null && !this.equals(existingCoolSupplies);
    if (isNewCoolSupplies)
    {
      aBundle.setCoolSupplies(this);
    }
    else
    {
      bundles.add(aBundle);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBundle(Bundle aBundle)
  {
    boolean wasRemoved = false;
    //Unable to remove aBundle, as it must always have a coolSupplies
    if (!this.equals(aBundle.getCoolSupplies()))
    {
      bundles.remove(aBundle);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBundleAt(Bundle aBundle, int index)
  {  
    boolean wasAdded = false;
    if(addBundle(aBundle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBundles()) { index = numberOfBundles() - 1; }
      bundles.remove(aBundle);
      bundles.add(index, aBundle);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBundleAt(Bundle aBundle, int index)
  {
    boolean wasAdded = false;
    if(bundles.contains(aBundle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBundles()) { index = numberOfBundles() - 1; }
      bundles.remove(aBundle);
      bundles.add(index, aBundle);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBundleAt(aBundle, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Item addItem(float aPrice, String aName)
  {
    return new Item(aPrice, aName, this);
  }

  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    CoolSupplies existingCoolSupplies = aItem.getCoolSupplies();
    boolean isNewCoolSupplies = existingCoolSupplies != null && !this.equals(existingCoolSupplies);
    if (isNewCoolSupplies)
    {
      aItem.setCoolSupplies(this);
    }
    else
    {
      items.add(aItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeItem(Item aItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aItem, as it must always have a coolSupplies
    if (!this.equals(aItem.getCoolSupplies()))
    {
      items.remove(aItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addItemAt(Item aItem, int index)
  {  
    boolean wasAdded = false;
    if(addItem(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveItemAt(Item aItem, int index)
  {
    boolean wasAdded = false;
    if(items.contains(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemAt(aItem, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addOrder(String aDate, int aOrderNumber, boolean aReady, boolean aPickedUp, Student aStudent, Transaction aOrderPayment)
  {
    return new Order(aDate, aOrderNumber, aReady, aPickedUp, aStudent, aOrderPayment, this);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    CoolSupplies existingCoolSupplies = aOrder.getCoolSupplies();
    boolean isNewCoolSupplies = existingCoolSupplies != null && !this.equals(existingCoolSupplies);
    if (isNewCoolSupplies)
    {
      aOrder.setCoolSupplies(this);
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
    //Unable to remove aOrder, as it must always have a coolSupplies
    if (!this.equals(aOrder.getCoolSupplies()))
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfItemPacks()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public ItemPack addItemPack(ItemPack.ImportanceLevel aImportanceLevel, int aRepetition, Bundle aBundle, Item aItem)
  {
    return new ItemPack(aImportanceLevel, aRepetition, this, aBundle, aItem);
  }

  public boolean addItemPack(ItemPack aItemPack)
  {
    boolean wasAdded = false;
    if (itemPacks.contains(aItemPack)) { return false; }
    CoolSupplies existingCoolSupplies = aItemPack.getCoolSupplies();
    boolean isNewCoolSupplies = existingCoolSupplies != null && !this.equals(existingCoolSupplies);
    if (isNewCoolSupplies)
    {
      aItemPack.setCoolSupplies(this);
    }
    else
    {
      itemPacks.add(aItemPack);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeItemPack(ItemPack aItemPack)
  {
    boolean wasRemoved = false;
    //Unable to remove aItemPack, as it must always have a coolSupplies
    if (!this.equals(aItemPack.getCoolSupplies()))
    {
      itemPacks.remove(aItemPack);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addItemPackAt(ItemPack aItemPack, int index)
  {  
    boolean wasAdded = false;
    if(addItemPack(aItemPack))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItemPacks()) { index = numberOfItemPacks() - 1; }
      itemPacks.remove(aItemPack);
      itemPacks.add(index, aItemPack);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveItemPackAt(ItemPack aItemPack, int index)
  {
    boolean wasAdded = false;
    if(itemPacks.contains(aItemPack))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItemPacks()) { index = numberOfItemPacks() - 1; }
      itemPacks.remove(aItemPack);
      itemPacks.add(index, aItemPack);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemPackAt(aItemPack, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRepetitions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Repetition addRepetition(int aRepetition, Order aOrder, Item aItem)
  {
    return new Repetition(aRepetition, this, aOrder, aItem);
  }

  public boolean addRepetition(Repetition aRepetition)
  {
    boolean wasAdded = false;
    if (repetitions.contains(aRepetition)) { return false; }
    CoolSupplies existingCoolSupplies = aRepetition.getCoolSupplies();
    boolean isNewCoolSupplies = existingCoolSupplies != null && !this.equals(existingCoolSupplies);
    if (isNewCoolSupplies)
    {
      aRepetition.setCoolSupplies(this);
    }
    else
    {
      repetitions.add(aRepetition);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRepetition(Repetition aRepetition)
  {
    boolean wasRemoved = false;
    //Unable to remove aRepetition, as it must always have a coolSupplies
    if (!this.equals(aRepetition.getCoolSupplies()))
    {
      repetitions.remove(aRepetition);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRepetitionAt(Repetition aRepetition, int index)
  {  
    boolean wasAdded = false;
    if(addRepetition(aRepetition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRepetitions()) { index = numberOfRepetitions() - 1; }
      repetitions.remove(aRepetition);
      repetitions.add(index, aRepetition);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRepetitionAt(Repetition aRepetition, int index)
  {
    boolean wasAdded = false;
    if(repetitions.contains(aRepetition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRepetitions()) { index = numberOfRepetitions() - 1; }
      repetitions.remove(aRepetition);
      repetitions.add(index, aRepetition);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRepetitionAt(aRepetition, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGrades()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Grade addGrade(String aGradeNumber)
  {
    return new Grade(aGradeNumber, this);
  }

  public boolean addGrade(Grade aGrade)
  {
    boolean wasAdded = false;
    if (grades.contains(aGrade)) { return false; }
    CoolSupplies existingCoolSupplies = aGrade.getCoolSupplies();
    boolean isNewCoolSupplies = existingCoolSupplies != null && !this.equals(existingCoolSupplies);
    if (isNewCoolSupplies)
    {
      aGrade.setCoolSupplies(this);
    }
    else
    {
      grades.add(aGrade);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGrade(Grade aGrade)
  {
    boolean wasRemoved = false;
    //Unable to remove aGrade, as it must always have a coolSupplies
    if (!this.equals(aGrade.getCoolSupplies()))
    {
      grades.remove(aGrade);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addGradeAt(Grade aGrade, int index)
  {  
    boolean wasAdded = false;
    if(addGrade(aGrade))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGrades()) { index = numberOfGrades() - 1; }
      grades.remove(aGrade);
      grades.add(index, aGrade);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGradeAt(Grade aGrade, int index)
  {
    boolean wasAdded = false;
    if(grades.contains(aGrade))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGrades()) { index = numberOfGrades() - 1; }
      grades.remove(aGrade);
      grades.add(index, aGrade);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGradeAt(aGrade, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (users.size() > 0)
    {
      User aUser = users.get(users.size() - 1);
      aUser.delete();
      users.remove(aUser);
    }
    
    while (students.size() > 0)
    {
      Student aStudent = students.get(students.size() - 1);
      aStudent.delete();
      students.remove(aStudent);
    }
    
    while (bundles.size() > 0)
    {
      Bundle aBundle = bundles.get(bundles.size() - 1);
      aBundle.delete();
      bundles.remove(aBundle);
    }
    
    while (items.size() > 0)
    {
      Item aItem = items.get(items.size() - 1);
      aItem.delete();
      items.remove(aItem);
    }
    
    while (orders.size() > 0)
    {
      Order aOrder = orders.get(orders.size() - 1);
      aOrder.delete();
      orders.remove(aOrder);
    }
    
    while (itemPacks.size() > 0)
    {
      ItemPack aItemPack = itemPacks.get(itemPacks.size() - 1);
      aItemPack.delete();
      itemPacks.remove(aItemPack);
    }
    
    while (repetitions.size() > 0)
    {
      Repetition aRepetition = repetitions.get(repetitions.size() - 1);
      aRepetition.delete();
      repetitions.remove(aRepetition);
    }
    
    while (grades.size() > 0)
    {
      Grade aGrade = grades.get(grades.size() - 1);
      aGrade.delete();
      grades.remove(aGrade);
    }
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "startOfSchoolYear" + ":" + getStartOfSchoolYear()+ "]";
  }
}