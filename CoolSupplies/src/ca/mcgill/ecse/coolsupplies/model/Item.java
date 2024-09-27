/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package ca.mcgill.ecse.coolsupplies.model;
import java.util.*;

// line 70 "../../../../../CoolSupplies.ump"
// line 166 "../../../../../CoolSupplies.ump"
public class Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Item Attributes
  private float price;
  private String name;

  //Item Associations
  private List<Order> orders;
  private List<Bundle> bundles;
  private CoolSupplies coolSupplies;
  private List<ItemPack> itemPacks;
  private List<Repetition> repetitions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Item(float aPrice, String aName, CoolSupplies aCoolSupplies)
  {
    price = aPrice;
    name = aName;
    orders = new ArrayList<Order>();
    bundles = new ArrayList<Bundle>();
    boolean didAddCoolSupplies = setCoolSupplies(aCoolSupplies);
    if (!didAddCoolSupplies)
    {
      throw new RuntimeException("Unable to create item due to coolSupplies. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    itemPacks = new ArrayList<ItemPack>();
    repetitions = new ArrayList<Repetition>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPrice(float aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public float getPrice()
  {
    return price;
  }

  public String getName()
  {
    return name;
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
    if (aOrder.indexOfItem(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aOrder.addItem(this);
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
    if (aOrder.indexOfItem(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aOrder.removeItem(this);
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
    if (aBundle.indexOfItem(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBundle.addItem(this);
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
    if (aBundle.indexOfItem(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBundle.removeItem(this);
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
      existingCoolSupplies.removeItem(this);
    }
    coolSupplies.addItem(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfItemPacks()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public ItemPack addItemPack(ItemPack.ImportanceLevel aImportanceLevel, int aRepetition, CoolSupplies aCoolSupplies, Bundle aBundle)
  {
    return new ItemPack(aImportanceLevel, aRepetition, aCoolSupplies, aBundle, this);
  }

  public boolean addItemPack(ItemPack aItemPack)
  {
    boolean wasAdded = false;
    if (itemPacks.contains(aItemPack)) { return false; }
    Item existingItem = aItemPack.getItem();
    boolean isNewItem = existingItem != null && !this.equals(existingItem);
    if (isNewItem)
    {
      aItemPack.setItem(this);
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
    //Unable to remove aItemPack, as it must always have a item
    if (!this.equals(aItemPack.getItem()))
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
  public Repetition addRepetition(int aRepetition, CoolSupplies aCoolSupplies, Order aOrder)
  {
    return new Repetition(aRepetition, aCoolSupplies, aOrder, this);
  }

  public boolean addRepetition(Repetition aRepetition)
  {
    boolean wasAdded = false;
    if (repetitions.contains(aRepetition)) { return false; }
    Item existingItem = aRepetition.getItem();
    boolean isNewItem = existingItem != null && !this.equals(existingItem);
    if (isNewItem)
    {
      aRepetition.setItem(this);
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
    //Unable to remove aRepetition, as it must always have a item
    if (!this.equals(aRepetition.getItem()))
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
    ArrayList<Order> copyOfOrders = new ArrayList<Order>(orders);
    orders.clear();
    for(Order aOrder : copyOfOrders)
    {
      aOrder.removeItem(this);
    }
    ArrayList<Bundle> copyOfBundles = new ArrayList<Bundle>(bundles);
    bundles.clear();
    for(Bundle aBundle : copyOfBundles)
    {
      if (aBundle.numberOfItems() <= Bundle.minimumNumberOfItems())
      {
        aBundle.delete();
      }
      else
      {
        aBundle.removeItem(this);
      }
    }
    CoolSupplies placeholderCoolSupplies = coolSupplies;
    this.coolSupplies = null;
    if(placeholderCoolSupplies != null)
    {
      placeholderCoolSupplies.removeItem(this);
    }
    for(int i=itemPacks.size(); i > 0; i--)
    {
      ItemPack aItemPack = itemPacks.get(i - 1);
      aItemPack.delete();
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
            "price" + ":" + getPrice()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "coolSupplies = "+(getCoolSupplies()!=null?Integer.toHexString(System.identityHashCode(getCoolSupplies())):"null");
  }
}