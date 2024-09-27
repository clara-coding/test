/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.34.0.7242.6b8819789 modeling language!*/



// line 72 "model.ump"
// line 148 "model.ump"
public class Importance
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum ImportanceLevel { Mandatory, Recommended, Optional }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Importance Attributes
  private ImportanceLevel importanceLevel;

  //Importance Associations
  private Bundle bundle;
  private Item item;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetBundle;
  private boolean canSetItem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Importance(ImportanceLevel aImportanceLevel, Bundle aBundle, Item aItem)
  {
    cachedHashCode = -1;
    canSetBundle = true;
    canSetItem = true;
    importanceLevel = aImportanceLevel;
    boolean didAddBundle = setBundle(aBundle);
    if (!didAddBundle)
    {
      throw new RuntimeException("Unable to create importance due to bundle. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddItem = setItem(aItem);
    if (!didAddItem)
    {
      throw new RuntimeException("Unable to create importance due to item. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setImportanceLevel(ImportanceLevel aImportanceLevel)
  {
    boolean wasSet = false;
    importanceLevel = aImportanceLevel;
    wasSet = true;
    return wasSet;
  }

  public ImportanceLevel getImportanceLevel()
  {
    return importanceLevel;
  }
  /* Code from template association_GetOne */
  public Bundle getBundle()
  {
    return bundle;
  }
  /* Code from template association_GetOne */
  public Item getItem()
  {
    return item;
  }
  /* Code from template association_SetOneToManyAssociationClass */
  public boolean setBundle(Bundle aBundle)
  {
    boolean wasSet = false;
    if (!canSetBundle) { return false; }
    if (aBundle == null)
    {
      return wasSet;
    }

    Bundle existingBundle = bundle;
    bundle = aBundle;
    if (existingBundle != null && !existingBundle.equals(aBundle))
    {
      existingBundle.removeImportance(this);
    }
    if (!bundle.addImportance(this))
    {
      bundle = existingBundle;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_SetOneToManyAssociationClass */
  public boolean setItem(Item aItem)
  {
    boolean wasSet = false;
    if (!canSetItem) { return false; }
    if (aItem == null)
    {
      return wasSet;
    }

    Item existingItem = item;
    item = aItem;
    if (existingItem != null && !existingItem.equals(aItem))
    {
      existingItem.removeImportance(this);
    }
    if (!item.addImportance(this))
    {
      item = existingItem;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Importance compareTo = (Importance)obj;
  
    if (getBundle() == null && compareTo.getBundle() != null)
    {
      return false;
    }
    else if (getBundle() != null && !getBundle().equals(compareTo.getBundle()))
    {
      return false;
    }

    if (getItem() == null && compareTo.getItem() != null)
    {
      return false;
    }
    else if (getItem() != null && !getItem().equals(compareTo.getItem()))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (getBundle() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getBundle().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (getItem() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getItem().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetBundle = false;
    canSetItem = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Bundle placeholderBundle = bundle;
    this.bundle = null;
    if(placeholderBundle != null)
    {
      placeholderBundle.removeImportance(this);
    }
    Item placeholderItem = item;
    this.item = null;
    if(placeholderItem != null)
    {
      placeholderItem.removeImportance(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "importanceLevel" + "=" + (getImportanceLevel() != null ? !getImportanceLevel().equals(this)  ? getImportanceLevel().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "bundle = "+(getBundle()!=null?Integer.toHexString(System.identityHashCode(getBundle())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "item = "+(getItem()!=null?Integer.toHexString(System.identityHashCode(getItem())):"null");
  }
}