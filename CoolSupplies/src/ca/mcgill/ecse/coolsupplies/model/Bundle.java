/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package ca.mcgill.ecse.coolsupplies.model;
import java.util.*;

// line 38 "../../../../../CoolSupplies.ump"
// line 135 "../../../../../CoolSupplies.ump"
public class Bundle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bundle Attributes
  private float discountPercentage;

  //Bundle Associations
  private List<Order> orders;
  private Grade grade;
  private List<Item> items;
  private CoolSupplies coolSupplies;
  private List<ItemPack> itemPacks;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bundle(float aDiscountPercentage, Grade aGrade, CoolSupplies aCoolSupplies, Item... allItems)
  {
    discountPercentage = aDiscountPercentage;
    orders = new ArrayList<Order>();
    boolean didAddGrade = setGrade(aGrade);
    if (!didAddGrade)
    {
      throw new RuntimeException("Unable to create bundle due to grade. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    items = new ArrayList<Item>();
    boolean didAddItems = setItems(allItems);
    if (!didAddItems)
    {
      throw new RuntimeException("Unable to create Bundle, must have at least 1 items. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddCoolSupplies = setCoolSupplies(aCoolSupplies);
    if (!didAddCoolSupplies)
    {
      throw new RuntimeException("Unable to create bundle due to coolSupplies. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    itemPacks = new ArrayList<ItemPack>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDiscountPercentage(float aDiscountPercentage)
  {
    boolean wasSet = false;
    discountPercentage = aDiscountPercentage;
    wasSet = true;
    return wasSet;
  }

  public float getDiscountPercentage()
  {
    return discountPercentage;
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
  /* Code from template association_GetOne */
  public CoolSupplies getCoolSupplies()
  {
    return coolSupplies;
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
  /* Code from template association_SetOneToOptionalOne */
  public boolean setGrade(Grade aNewGrade)
  {
    boolean wasSet = false;
    if (aNewGrade == null)
    {
      //Unable to setGrade to null, as bundle must always be associated to a grade
      return wasSet;
    }
    
    Bundle existingBundle = aNewGrade.getBundle();
    if (existingBundle != null && !equals(existingBundle))
    {
      //Unable to setGrade, the current grade already has a bundle, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Grade anOldGrade = grade;
    grade = aNewGrade;
    grade.setBundle(this);

    if (anOldGrade != null)
    {
      anOldGrade.setBundle(null);
    }
    wasSet = true;
    return wasSet;
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
      existingCoolSupplies.removeBundle(this);
    }
    coolSupplies.addBundle(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfItemPacks()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public ItemPack addItemPack(ItemPack.ImportanceLevel aImportanceLevel, int aRepetition, CoolSupplies aCoolSupplies, Item aItem)
  {
    return new ItemPack(aImportanceLevel, aRepetition, aCoolSupplies, this, aItem);
  }

  public boolean addItemPack(ItemPack aItemPack)
  {
    boolean wasAdded = false;
    if (itemPacks.contains(aItemPack)) { return false; }
    Bundle existingBundle = aItemPack.getBundle();
    boolean isNewBundle = existingBundle != null && !this.equals(existingBundle);
    if (isNewBundle)
    {
      aItemPack.setBundle(this);
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
    //Unable to remove aItemPack, as it must always have a bundle
    if (!this.equals(aItemPack.getBundle()))
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
      existingGrade.setBundle(null);
    }
    ArrayList<Item> copyOfItems = new ArrayList<Item>(items);
    items.clear();
    for(Item aItem : copyOfItems)
    {
      aItem.removeBundle(this);
    }
    CoolSupplies placeholderCoolSupplies = coolSupplies;
    this.coolSupplies = null;
    if(placeholderCoolSupplies != null)
    {
      placeholderCoolSupplies.removeBundle(this);
    }
    for(int i=itemPacks.size(); i > 0; i--)
    {
      ItemPack aItemPack = itemPacks.get(i - 1);
      aItemPack.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "discountPercentage" + ":" + getDiscountPercentage()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "grade = "+(getGrade()!=null?Integer.toHexString(System.identityHashCode(getGrade())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "coolSupplies = "+(getCoolSupplies()!=null?Integer.toHexString(System.identityHashCode(getCoolSupplies())):"null");
  }
}