/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.34.0.7242.6b8819789 modeling language!*/


import java.util.*;

// line 43 "model.ump"
// line 122 "model.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private string date;
  private int orderNumber;
  private boolean pickedUp;

  //Order Associations
  private Student student;
  private Penalty penalty;
  private Transaction transaction;
  private List<Bundle> bundles;
  private List<Item> items;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(string aDate, int aOrderNumber, boolean aPickedUp, Student aStudent)
  {
    date = aDate;
    orderNumber = aOrderNumber;
    pickedUp = aPickedUp;
    boolean didAddStudent = setStudent(aStudent);
    if (!didAddStudent)
    {
      throw new RuntimeException("Unable to create order due to student. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    bundles = new ArrayList<Bundle>();
    items = new ArrayList<Item>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(string aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setOrderNumber(int aOrderNumber)
  {
    boolean wasSet = false;
    orderNumber = aOrderNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setPickedUp(boolean aPickedUp)
  {
    boolean wasSet = false;
    pickedUp = aPickedUp;
    wasSet = true;
    return wasSet;
  }

  public string getDate()
  {
    return date;
  }

  public int getOrderNumber()
  {
    return orderNumber;
  }

  public boolean getPickedUp()
  {
    return pickedUp;
  }
  /* Code from template association_GetOne */
  public Student getStudent()
  {
    return student;
  }
  /* Code from template association_GetOne */
  public Penalty getPenalty()
  {
    return penalty;
  }

  public boolean hasPenalty()
  {
    boolean has = penalty != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Transaction getTransaction()
  {
    return transaction;
  }

  public boolean hasTransaction()
  {
    boolean has = transaction != null;
    return has;
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
  /* Code from template association_SetOneToMany */
  public boolean setStudent(Student aStudent)
  {
    boolean wasSet = false;
    if (aStudent == null)
    {
      return wasSet;
    }

    Student existingStudent = student;
    student = aStudent;
    if (existingStudent != null && !existingStudent.equals(aStudent))
    {
      existingStudent.removeOrder(this);
    }
    student.addOrder(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setPenalty(Penalty aNewPenalty)
  {
    boolean wasSet = false;
    if (penalty != null && !penalty.equals(aNewPenalty) && equals(penalty.getOrder()))
    {
      //Unable to setPenalty, as existing penalty would become an orphan
      return wasSet;
    }

    penalty = aNewPenalty;
    Order anOldOrder = aNewPenalty != null ? aNewPenalty.getOrder() : null;

    if (!this.equals(anOldOrder))
    {
      if (anOldOrder != null)
      {
        anOldOrder.penalty = null;
      }
      if (penalty != null)
      {
        penalty.setOrder(this);
      }
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setTransaction(Transaction aNewTransaction)
  {
    boolean wasSet = false;
    if (transaction != null && !transaction.equals(aNewTransaction) && equals(transaction.getOrder()))
    {
      //Unable to setTransaction, as existing transaction would become an orphan
      return wasSet;
    }

    transaction = aNewTransaction;
    Order anOldOrder = aNewTransaction != null ? aNewTransaction.getOrder() : null;

    if (!this.equals(anOldOrder))
    {
      if (anOldOrder != null)
      {
        anOldOrder.transaction = null;
      }
      if (transaction != null)
      {
        transaction.setOrder(this);
      }
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBundles()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addBundle(Bundle aBundle)
  {
    boolean wasAdded = false;
    if (bundles.contains(aBundle)) { return false; }
    bundles.add(aBundle);
    if (aBundle.indexOfOrder(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBundle.addOrder(this);
      if (!wasAdded)
      {
        bundles.remove(aBundle);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeBundle(Bundle aBundle)
  {
    boolean wasRemoved = false;
    if (!bundles.contains(aBundle))
    {
      return wasRemoved;
    }

    int oldIndex = bundles.indexOf(aBundle);
    bundles.remove(oldIndex);
    if (aBundle.indexOfOrder(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBundle.removeOrder(this);
      if (!wasRemoved)
      {
        bundles.add(oldIndex,aBundle);
      }
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
  /* Code from template association_AddManyToManyMethod */
  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    items.add(aItem);
    if (aItem.indexOfOrder(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aItem.addOrder(this);
      if (!wasAdded)
      {
        items.remove(aItem);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeItem(Item aItem)
  {
    boolean wasRemoved = false;
    if (!items.contains(aItem))
    {
      return wasRemoved;
    }

    int oldIndex = items.indexOf(aItem);
    items.remove(oldIndex);
    if (aItem.indexOfOrder(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aItem.removeOrder(this);
      if (!wasRemoved)
      {
        items.add(oldIndex,aItem);
      }
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

  public void delete()
  {
    Student placeholderStudent = student;
    this.student = null;
    if(placeholderStudent != null)
    {
      placeholderStudent.removeOrder(this);
    }
    Penalty existingPenalty = penalty;
    penalty = null;
    if (existingPenalty != null)
    {
      existingPenalty.delete();
      existingPenalty.setOrder(null);
    }
    Transaction existingTransaction = transaction;
    transaction = null;
    if (existingTransaction != null)
    {
      existingTransaction.delete();
      existingTransaction.setOrder(null);
    }
    ArrayList<Bundle> copyOfBundles = new ArrayList<Bundle>(bundles);
    bundles.clear();
    for(Bundle aBundle : copyOfBundles)
    {
      aBundle.removeOrder(this);
    }
    ArrayList<Item> copyOfItems = new ArrayList<Item>(items);
    items.clear();
    for(Item aItem : copyOfItems)
    {
      aItem.removeOrder(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "orderNumber" + ":" + getOrderNumber()+ "," +
            "pickedUp" + ":" + getPickedUp()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "student = "+(getStudent()!=null?Integer.toHexString(System.identityHashCode(getStudent())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "penalty = "+(getPenalty()!=null?Integer.toHexString(System.identityHashCode(getPenalty())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "transaction = "+(getTransaction()!=null?Integer.toHexString(System.identityHashCode(getTransaction())):"null");
  }
}