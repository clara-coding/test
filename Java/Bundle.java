/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.34.0.7242.6b8819789 modeling language!*/


import java.util.*;

// line 35 "model.ump"
// line 113 "model.ump"
public class Bundle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bundle Attributes
  private float discount;

  //Bundle Associations
  private List<Order> orders;
  private Grade grade;
  private List<Item> items;
  private List<Importance> importances;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bundle(float aDiscount, Grade aGrade, Item... allItems)
  {
    discount = aDiscount;
    orders = new ArrayList<Order>();
    if (aGrade == null || aGrade.getBundle() != null)
    {
      throw new RuntimeException("Unable to create Bundle due to aGrade. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    grade = aGrade;
    items = new ArrayList<Item>();
    boolean didAddItems = setItems(allItems);
    if (!didAddItems)
    {
      throw new RuntimeException("Unable to create Bundle, must have at least 1 items. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    importances = new ArrayList<Importance>();
  }

  public Bundle(float aDiscount, string aNameForGrade, Item... allItems)
  {
    discount = aDiscount;
    orders = new ArrayList<Order>();
    grade = new Grade(aNameForGrade, this);
    items = new ArrayList<Item>();
    boolean didAddItems = setItems(allItems);
    if (!didAddItems)
    {
      throw new RuntimeException("Unable to create Bundle, must have at least 1 items. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    importances = new ArrayList<Importance>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDiscount(float aDiscount)
  {
    boolean wasSet = false;
    discount = aDiscount;
    wasSet = true;
    return wasSet;
  }

  public float getDiscount()
  {
    return discount;
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
  /* Code from template association_GetOne */
  public Grade getGrade()
  {
    return grade;
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
  public Importance getImportance(int index)
  {
    Importance aImportance = importances.get(index);
    return aImportance;
  }

  public List<Importance> getImportances()
  {
    List<Importance> newImportances = Collections.unmodifiableList(importances);
    return newImportances;
  }

  public int numberOfImportances()
  {
    int number = importances.size();
    return number;
  }

  public boolean hasImportances()
  {
    boolean has = importances.size() > 0;
    return has;
  }

  public int indexOfImportance(Importance aImportance)
  {
    int index = importances.indexOf(aImportance);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    orders.add(aOrder);
    if (aOrder.indexOfBundle(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aOrder.addBundle(this);
      if (!wasAdded)
      {
        orders.remove(aOrder);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    if (!orders.contains(aOrder))
    {
      return wasRemoved;
    }

    int oldIndex = orders.indexOf(aOrder);
    orders.remove(oldIndex);
    if (aOrder.indexOfBundle(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aOrder.removeBundle(this);
      if (!wasRemoved)
      {
        orders.add(oldIndex,aOrder);
      }
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
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfItemsValid()
  {
    boolean isValid = numberOfItems() >= minimumNumberOfItems();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfItems()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    items.add(aItem);
    if (aItem.indexOfBundle(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aItem.addBundle(this);
      if (!wasAdded)
      {
        items.remove(aItem);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeItem(Item aItem)
  {
    boolean wasRemoved = false;
    if (!items.contains(aItem))
    {
      return wasRemoved;
    }

    if (numberOfItems() <= minimumNumberOfItems())
    {
      return wasRemoved;
    }

    int oldIndex = items.indexOf(aItem);
    items.remove(oldIndex);
    if (aItem.indexOfBundle(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aItem.removeBundle(this);
      if (!wasRemoved)
      {
        items.add(oldIndex,aItem);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setItems(Item... newItems)
  {
    boolean wasSet = false;
    ArrayList<Item> verifiedItems = new ArrayList<Item>();
    for (Item aItem : newItems)
    {
      if (verifiedItems.contains(aItem))
      {
        continue;
      }
      verifiedItems.add(aItem);
    }

    if (verifiedItems.size() != newItems.length || verifiedItems.size() < minimumNumberOfItems())
    {
      return wasSet;
    }

    ArrayList<Item> oldItems = new ArrayList<Item>(items);
    items.clear();
    for (Item aNewItem : verifiedItems)
    {
      items.add(aNewItem);
      if (oldItems.contains(aNewItem))
      {
        oldItems.remove(aNewItem);
      }
      else
      {
        aNewItem.addBundle(this);
      }
    }

    for (Item anOldItem : oldItems)
    {
      anOldItem.removeBundle(this);
    }
    wasSet = true;
    return wasSet;
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
  public static int minimumNumberOfImportances()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Importance addImportance(Importance.ImportanceLevel aImportanceLevel, Item aItem)
  {
    return new Importance(aImportanceLevel, this, aItem);
  }

  public boolean addImportance(Importance aImportance)
  {
    boolean wasAdded = false;
    if (importances.contains(aImportance)) { return false; }
    Bundle existingBundle = aImportance.getBundle();
    boolean isNewBundle = existingBundle != null && !this.equals(existingBundle);
    if (isNewBundle)
    {
      aImportance.setBundle(this);
    }
    else
    {
      importances.add(aImportance);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeImportance(Importance aImportance)
  {
    boolean wasRemoved = false;
    //Unable to remove aImportance, as it must always have a bundle
    if (!this.equals(aImportance.getBundle()))
    {
      importances.remove(aImportance);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addImportanceAt(Importance aImportance, int index)
  {  
    boolean wasAdded = false;
    if(addImportance(aImportance))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfImportances()) { index = numberOfImportances() - 1; }
      importances.remove(aImportance);
      importances.add(index, aImportance);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveImportanceAt(Importance aImportance, int index)
  {
    boolean wasAdded = false;
    if(importances.contains(aImportance))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfImportances()) { index = numberOfImportances() - 1; }
      importances.remove(aImportance);
      importances.add(index, aImportance);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addImportanceAt(aImportance, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Order> copyOfOrders = new ArrayList<Order>(orders);
    orders.clear();
    for(Order aOrder : copyOfOrders)
    {
      aOrder.removeBundle(this);
    }
    Grade existingGrade = grade;
    grade = null;
    if (existingGrade != null)
    {
      existingGrade.delete();
    }
    ArrayList<Item> copyOfItems = new ArrayList<Item>(items);
    items.clear();
    for(Item aItem : copyOfItems)
    {
      aItem.removeBundle(this);
    }
    for(int i=importances.size(); i > 0; i--)
    {
      Importance aImportance = importances.get(i - 1);
      aImportance.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "discount" + ":" + getDiscount()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "grade = "+(getGrade()!=null?Integer.toHexString(System.identityHashCode(getGrade())):"null");
  }
}