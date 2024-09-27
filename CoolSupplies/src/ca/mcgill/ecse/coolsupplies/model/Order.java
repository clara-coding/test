/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package ca.mcgill.ecse.coolsupplies.model;
import java.util.*;

// line 46 "../../../../../CoolSupplies.ump"
// line 144 "../../../../../CoolSupplies.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private String date;
  private int orderNumber;
  private boolean ready;
  private boolean pickedUp;

  //Order Associations
  private Student student;
  private Penalty penalty;
  private Transaction orderPayment;
  private List<Bundle> bundles;
  private List<Item> items;
  private CoolSupplies coolSupplies;
  private List<Repetition> repetitions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(String aDate, int aOrderNumber, boolean aReady, boolean aPickedUp, Student aStudent, Transaction aOrderPayment, CoolSupplies aCoolSupplies)
  {
    date = aDate;
    orderNumber = aOrderNumber;
    ready = aReady;
    pickedUp = aPickedUp;
    boolean didAddStudent = setStudent(aStudent);
    if (!didAddStudent)
    {
      throw new RuntimeException("Unable to create order due to student. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddOrderPayment = setOrderPayment(aOrderPayment);
    if (!didAddOrderPayment)
    {
      throw new RuntimeException("Unable to create order due to orderPayment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    bundles = new ArrayList<Bundle>();
    items = new ArrayList<Item>();
    boolean didAddCoolSupplies = setCoolSupplies(aCoolSupplies);
    if (!didAddCoolSupplies)
    {
      throw new RuntimeException("Unable to create order due to coolSupplies. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    repetitions = new ArrayList<Repetition>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(String aDate)
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

  public boolean setReady(boolean aReady)
  {
    boolean wasSet = false;
    ready = aReady;
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

  public String getDate()
  {
    return date;
  }

  public int getOrderNumber()
  {
    return orderNumber;
  }

  public boolean getReady()
  {
    return ready;
  }

  public boolean getPickedUp()
  {
    return pickedUp;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isReady()
  {
    return ready;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isPickedUp()
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
  public Transaction getOrderPayment()
  {
    return orderPayment;
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
  /* Code from template association_GetOne */
  public CoolSupplies getCoolSupplies()
  {
    return coolSupplies;
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
  /* Code from template association_SetOneToOptionalOne */
  public boolean setOrderPayment(Transaction aNewOrderPayment)
  {
    boolean wasSet = false;
    if (aNewOrderPayment == null)
    {
      //Unable to setOrderPayment to null, as order must always be associated to a orderPayment
      return wasSet;
    }
    
    Order existingOrder = aNewOrderPayment.getOrder();
    if (existingOrder != null && !equals(existingOrder))
    {
      //Unable to setOrderPayment, the current orderPayment already has a order, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Transaction anOldOrderPayment = orderPayment;
    orderPayment = aNewOrderPayment;
    orderPayment.setOrder(this);

    if (anOldOrderPayment != null)
    {
      anOldOrderPayment.setOrder(null);
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
      existingCoolSupplies.removeOrder(this);
    }
    coolSupplies.addOrder(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRepetitions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Repetition addRepetition(int aRepetition, CoolSupplies aCoolSupplies, Item aItem)
  {
    return new Repetition(aRepetition, aCoolSupplies, this, aItem);
  }

  public boolean addRepetition(Repetition aRepetition)
  {
    boolean wasAdded = false;
    if (repetitions.contains(aRepetition)) { return false; }
    Order existingOrder = aRepetition.getOrder();
    boolean isNewOrder = existingOrder != null && !this.equals(existingOrder);
    if (isNewOrder)
    {
      aRepetition.setOrder(this);
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
    //Unable to remove aRepetition, as it must always have a order
    if (!this.equals(aRepetition.getOrder()))
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
    Transaction existingOrderPayment = orderPayment;
    orderPayment = null;
    if (existingOrderPayment != null)
    {
      existingOrderPayment.delete();
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
    CoolSupplies placeholderCoolSupplies = coolSupplies;
    this.coolSupplies = null;
    if(placeholderCoolSupplies != null)
    {
      placeholderCoolSupplies.removeOrder(this);
    }
    for(int i=repetitions.size(); i > 0; i--)
    {
      Repetition aRepetition = repetitions.get(i - 1);
      aRepetition.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "date" + ":" + getDate()+ "," +
            "orderNumber" + ":" + getOrderNumber()+ "," +
            "ready" + ":" + getReady()+ "," +
            "pickedUp" + ":" + getPickedUp()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "student = "+(getStudent()!=null?Integer.toHexString(System.identityHashCode(getStudent())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "penalty = "+(getPenalty()!=null?Integer.toHexString(System.identityHashCode(getPenalty())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "orderPayment = "+(getOrderPayment()!=null?Integer.toHexString(System.identityHashCode(getOrderPayment())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "coolSupplies = "+(getCoolSupplies()!=null?Integer.toHexString(System.identityHashCode(getCoolSupplies())):"null");
  }
}