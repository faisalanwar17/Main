/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 27 "model.ump"
// line 231 "model.ump"
public class TicketType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TicketType Attributes
  private String typeID;
  private String name;
  private int price;
  private int availability;

  //TicketType Associations
  private List<MarketingCampaign> marketingCampaigns;
  private Event event;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TicketType(String aTypeID, String aName, int aPrice, int aAvailability, Event aEvent)
  {
    typeID = aTypeID;
    name = aName;
    price = aPrice;
    availability = aAvailability;
    marketingCampaigns = new ArrayList<MarketingCampaign>();
    boolean didAddEvent = setEvent(aEvent);
    if (!didAddEvent)
    {
      throw new RuntimeException("Unable to create ticketType due to event. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTypeID(String aTypeID)
  {
    boolean wasSet = false;
    typeID = aTypeID;
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

  public boolean setPrice(int aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setAvailability(int aAvailability)
  {
    boolean wasSet = false;
    availability = aAvailability;
    wasSet = true;
    return wasSet;
  }

  public String getTypeID()
  {
    return typeID;
  }

  public String getName()
  {
    return name;
  }

  public int getPrice()
  {
    return price;
  }

  public int getAvailability()
  {
    return availability;
  }
  /* Code from template association_GetMany */
  public MarketingCampaign getMarketingCampaign(int index)
  {
    MarketingCampaign aMarketingCampaign = marketingCampaigns.get(index);
    return aMarketingCampaign;
  }

  public List<MarketingCampaign> getMarketingCampaigns()
  {
    List<MarketingCampaign> newMarketingCampaigns = Collections.unmodifiableList(marketingCampaigns);
    return newMarketingCampaigns;
  }

  public int numberOfMarketingCampaigns()
  {
    int number = marketingCampaigns.size();
    return number;
  }

  public boolean hasMarketingCampaigns()
  {
    boolean has = marketingCampaigns.size() > 0;
    return has;
  }

  public int indexOfMarketingCampaign(MarketingCampaign aMarketingCampaign)
  {
    int index = marketingCampaigns.indexOf(aMarketingCampaign);
    return index;
  }
  /* Code from template association_GetOne */
  public Event getEvent()
  {
    return event;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMarketingCampaigns()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addMarketingCampaign(MarketingCampaign aMarketingCampaign)
  {
    boolean wasAdded = false;
    if (marketingCampaigns.contains(aMarketingCampaign)) { return false; }
    marketingCampaigns.add(aMarketingCampaign);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMarketingCampaign(MarketingCampaign aMarketingCampaign)
  {
    boolean wasRemoved = false;
    if (marketingCampaigns.contains(aMarketingCampaign))
    {
      marketingCampaigns.remove(aMarketingCampaign);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addMarketingCampaignAt(MarketingCampaign aMarketingCampaign, int index)
  {  
    boolean wasAdded = false;
    if(addMarketingCampaign(aMarketingCampaign))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMarketingCampaigns()) { index = numberOfMarketingCampaigns() - 1; }
      marketingCampaigns.remove(aMarketingCampaign);
      marketingCampaigns.add(index, aMarketingCampaign);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMarketingCampaignAt(MarketingCampaign aMarketingCampaign, int index)
  {
    boolean wasAdded = false;
    if(marketingCampaigns.contains(aMarketingCampaign))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMarketingCampaigns()) { index = numberOfMarketingCampaigns() - 1; }
      marketingCampaigns.remove(aMarketingCampaign);
      marketingCampaigns.add(index, aMarketingCampaign);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMarketingCampaignAt(aMarketingCampaign, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setEvent(Event aEvent)
  {
    boolean wasSet = false;
    if (aEvent == null)
    {
      return wasSet;
    }

    Event existingEvent = event;
    event = aEvent;
    if (existingEvent != null && !existingEvent.equals(aEvent))
    {
      existingEvent.removeTicketType(this);
    }
    event.addTicketType(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    marketingCampaigns.clear();
    Event placeholderEvent = event;
    this.event = null;
    if(placeholderEvent != null)
    {
      placeholderEvent.removeTicketType(this);
    }
  }

  // line 37 "model.ump"
   public void createTicketType(){
    
  }

  // line 40 "model.ump"
   public void updateTicketType(){
    
  }

  // line 43 "model.ump"
   public void getTicket(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "typeID" + ":" + getTypeID()+ "," +
            "name" + ":" + getName()+ "," +
            "price" + ":" + getPrice()+ "," +
            "availability" + ":" + getAvailability()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "event = "+(getEvent()!=null?Integer.toHexString(System.identityHashCode(getEvent())):"null");
  }
}