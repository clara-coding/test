/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package ca.mcgill.ecse.coolsupplies.model;
import java.util.*;

// line 63 "../../../../../CoolSupplies.ump"
// line 161 "../../../../../CoolSupplies.ump"
public class Transaction
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Transaction> transactionsById = new HashMap<String, Transaction>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transaction Attributes
  private String id;
  private String authorizationCode;
  private boolean isPenalty;

  //Transaction Associations
  private Order order;
  private Penalty penalty;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(String aId, String aAuthorizationCode, boolean aIsPenalty)
  {
    authorizationCode = aAuthorizationCode;
    isPenalty = aIsPenalty;
    if (!setId(aId))
    {
      throw new RuntimeException("Cannot create due to duplicate id. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    String anOldId = getId();
    if (anOldId != null && anOldId.equals(aId)) {
      return true;
    }
    if (hasWithId(aId)) {
      return wasSet;
    }
    id = aId;
    wasSet = true;
    if (anOldId != null) {
      transactionsById.remove(anOldId);
    }
    transactionsById.put(aId, this);
    return wasSet;
  }

  public boolean setAuthorizationCode(String aAuthorizationCode)
  {
    boolean wasSet = false;
    authorizationCode = aAuthorizationCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsPenalty(boolean aIsPenalty)
  {
    boolean wasSet = false;
    isPenalty = aIsPenalty;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }
  /* Code from template attribute_GetUnique */
  public static Transaction getWithId(String aId)
  {
    return transactionsById.get(aId);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithId(String aId)
  {
    return getWithId(aId) != null;
  }

  public String getAuthorizationCode()
  {
    return authorizationCode;
  }

  public boolean getIsPenalty()
  {
    return isPenalty;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsPenalty()
  {
    return isPenalty;
  }
  /* Code from template association_GetOne */
  public Order getOrder()
  {
    return order;
  }

  public boolean hasOrder()
  {
    boolean has = order != null;
    return has;
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
  /* Code from template association_SetOptionalOneToOne */
  public boolean setOrder(Order aNewOrder)
  {
    boolean wasSet = false;
    if (order != null && !order.equals(aNewOrder) && equals(order.getOrderPayment()))
    {
      //Unable to setOrder, as existing order would become an orphan
      return wasSet;
    }

    order = aNewOrder;
    Transaction anOldOrderPayment = aNewOrder != null ? aNewOrder.getOrderPayment() : null;

    if (!this.equals(anOldOrderPayment))
    {
      if (anOldOrderPayment != null)
      {
        anOldOrderPayment.order = null;
      }
      if (order != null)
      {
        order.setOrderPayment(this);
      }
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setPenalty(Penalty aNewPenalty)
  {
    boolean wasSet = false;
    if (penalty != null && !penalty.equals(aNewPenalty) && equals(penalty.getTransaction()))
    {
      //Unable to setPenalty, as existing penalty would become an orphan
      return wasSet;
    }

    penalty = aNewPenalty;
    Transaction anOldTransaction = aNewPenalty != null ? aNewPenalty.getTransaction() : null;

    if (!this.equals(anOldTransaction))
    {
      if (anOldTransaction != null)
      {
        anOldTransaction.penalty = null;
      }
      if (penalty != null)
      {
        penalty.setTransaction(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    transactionsById.remove(getId());
    Order existingOrder = order;
    order = null;
    if (existingOrder != null)
    {
      existingOrder.delete();
    }
    Penalty existingPenalty = penalty;
    penalty = null;
    if (existingPenalty != null)
    {
      existingPenalty.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "authorizationCode" + ":" + getAuthorizationCode()+ "," +
            "isPenalty" + ":" + getIsPenalty()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "penalty = "+(getPenalty()!=null?Integer.toHexString(System.identityHashCode(getPenalty())):"null");
  }
}