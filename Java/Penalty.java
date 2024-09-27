/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.34.0.7242.6b8819789 modeling language!*/



// line 53 "model.ump"
// line 131 "model.ump"
public class Penalty
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Penalty Attributes
  private float amount;

  //Penalty Associations
  private Transaction transaction;
  private Order order;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Penalty(float aAmount, Transaction aTransaction, Order aOrder)
  {
    amount = aAmount;
    boolean didAddTransaction = setTransaction(aTransaction);
    if (!didAddTransaction)
    {
      throw new RuntimeException("Unable to create penalty due to transaction. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddOrder = setOrder(aOrder);
    if (!didAddOrder)
    {
      throw new RuntimeException("Unable to create penalty due to order. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAmount(float aAmount)
  {
    boolean wasSet = false;
    amount = aAmount;
    wasSet = true;
    return wasSet;
  }

  public float getAmount()
  {
    return amount;
  }
  /* Code from template association_GetOne */
  public Transaction getTransaction()
  {
    return transaction;
  }
  /* Code from template association_GetOne */
  public Order getOrder()
  {
    return order;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setTransaction(Transaction aNewTransaction)
  {
    boolean wasSet = false;
    if (aNewTransaction == null)
    {
      //Unable to setTransaction to null, as penalty must always be associated to a transaction
      return wasSet;
    }
    
    Penalty existingPenalty = aNewTransaction.getPenalty();
    if (existingPenalty != null && !equals(existingPenalty))
    {
      //Unable to setTransaction, the current transaction already has a penalty, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Transaction anOldTransaction = transaction;
    transaction = aNewTransaction;
    transaction.setPenalty(this);

    if (anOldTransaction != null)
    {
      anOldTransaction.setPenalty(null);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setOrder(Order aNewOrder)
  {
    boolean wasSet = false;
    if (aNewOrder == null)
    {
      //Unable to setOrder to null, as penalty must always be associated to a order
      return wasSet;
    }
    
    Penalty existingPenalty = aNewOrder.getPenalty();
    if (existingPenalty != null && !equals(existingPenalty))
    {
      //Unable to setOrder, the current order already has a penalty, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Order anOldOrder = order;
    order = aNewOrder;
    order.setPenalty(this);

    if (anOldOrder != null)
    {
      anOldOrder.setPenalty(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Transaction existingTransaction = transaction;
    transaction = null;
    if (existingTransaction != null)
    {
      existingTransaction.setPenalty(null);
    }
    Order existingOrder = order;
    order = null;
    if (existingOrder != null)
    {
      existingOrder.setPenalty(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "amount" + ":" + getAmount()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "transaction = "+(getTransaction()!=null?Integer.toHexString(System.identityHashCode(getTransaction())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null");
  }
}