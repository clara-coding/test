/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.34.0.7242.6b8819789 modeling language!*/



// line 59 "model.ump"
// line 137 "model.ump"
public class Transaction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transaction Attributes
  private string authorizationCode;
  private boolean isPenalty;

  //Transaction Associations
  private Order order;
  private Penalty penalty;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(string aAuthorizationCode, boolean aIsPenalty, Order aOrder)
  {
    authorizationCode = aAuthorizationCode;
    isPenalty = aIsPenalty;
    boolean didAddOrder = setOrder(aOrder);
    if (!didAddOrder)
    {
      throw new RuntimeException("Unable to create transaction due to order. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAuthorizationCode(string aAuthorizationCode)
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

  public string getAuthorizationCode()
  {
    return authorizationCode;
  }

  public boolean getIsPenalty()
  {
    return isPenalty;
  }
  /* Code from template association_GetOne */
  public Order getOrder()
  {
    return order;
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
  /* Code from template association_SetOneToOptionalOne */
  public boolean setOrder(Order aNewOrder)
  {
    boolean wasSet = false;
    if (aNewOrder == null)
    {
      //Unable to setOrder to null, as transaction must always be associated to a order
      return wasSet;
    }
    
    Transaction existingTransaction = aNewOrder.getTransaction();
    if (existingTransaction != null && !equals(existingTransaction))
    {
      //Unable to setOrder, the current order already has a transaction, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Order anOldOrder = order;
    order = aNewOrder;
    order.setTransaction(this);

    if (anOldOrder != null)
    {
      anOldOrder.setTransaction(null);
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
    Order existingOrder = order;
    order = null;
    if (existingOrder != null)
    {
      existingOrder.setTransaction(null);
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
            "isPenalty" + ":" + getIsPenalty()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "authorizationCode" + "=" + (getAuthorizationCode() != null ? !getAuthorizationCode().equals(this)  ? getAuthorizationCode().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "penalty = "+(getPenalty()!=null?Integer.toHexString(System.identityHashCode(getPenalty())):"null");
  }
}