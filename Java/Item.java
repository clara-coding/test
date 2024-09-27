/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.34.0.7242.6b8819789 modeling language!*/


import java.util.*;

// line 65 "model.ump"
// line 142 "model.ump"
public class Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Item Attributes
  private float price;
  private string name;

  //Item Associations
  private List<Order> orders;
  private List<Bundle> bundles;
  private List<Importance> importances;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Item(float aPrice, string aName)
  {
    price = aPrice;
    name = aName;
    orders = new ArrayList<Order>();
    bundles = new ArrayList<Bundle>();
    importances = new ArrayList<Importance>();
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

  public boolean setName(string aName)
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

  public string getName()
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfImportances()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Importance addImportance(Importance.ImportanceLevel aImportanceLevel, Bundle aBundle)
  {
    return new Importance(aImportanceLevel, aBundle, this);
  }

  public boolean addImportance(Importance aImportance)
  {
    boolean wasAdded = false;
    if (importances.contains(aImportance)) { return false; }
    Item existingItem = aImportance.getItem();
    boolean isNewItem = existingItem != null && !this.equals(existingItem);
    if (isNewItem)
    {
      aImportance.setItem(this);
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
    //Unable to remove aImportance, as it must always have a item
    if (!this.equals(aImportance.getItem()))
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
    for(int i=importances.size(); i > 0; i--)
    {
      Importance aImportance = importances.get(i - 1);
      aImportance.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "price" + ":" + getPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "name" + "=" + (getName() != null ? !getName().equals(this)  ? getName().toString().replaceAll("  ","    ") : "this" : "null");
  }
}