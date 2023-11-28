/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 102 "model.ump"
// line 256 "model.ump"
public class Ticket
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ticket Attributes
  private String ticketID;
  private String type;
  private String qrCode;
  private String status;

  //Ticket Associations
  private Event event;
  private List<Attendee> attendees;
  private MarketingCampaign marketingCampaign;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ticket(String aTicketID, String aType, String aQrCode, String aStatus, Event aEvent, MarketingCampaign aMarketingCampaign)
  {
    ticketID = aTicketID;
    type = aType;
    qrCode = aQrCode;
    status = aStatus;
    boolean didAddEvent = setEvent(aEvent);
    if (!didAddEvent)
    {
      throw new RuntimeException("Unable to create ticket due to event. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    attendees = new ArrayList<Attendee>();
    boolean didAddMarketingCampaign = setMarketingCampaign(aMarketingCampaign);
    if (!didAddMarketingCampaign)
    {
      throw new RuntimeException("Unable to create ticket due to marketingCampaign. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTicketID(String aTicketID)
  {
    boolean wasSet = false;
    ticketID = aTicketID;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setQrCode(String aQrCode)
  {
    boolean wasSet = false;
    qrCode = aQrCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setStatus(String aStatus)
  {
    boolean wasSet = false;
    status = aStatus;
    wasSet = true;
    return wasSet;
  }

  public String getTicketID()
  {
    return ticketID;
  }

  public String getType()
  {
    return type;
  }

  public String getQrCode()
  {
    return qrCode;
  }

  public String getStatus()
  {
    return status;
  }
  /* Code from template association_GetOne */
  public Event getEvent()
  {
    return event;
  }
  /* Code from template association_GetMany */
  public Attendee getAttendee(int index)
  {
    Attendee aAttendee = attendees.get(index);
    return aAttendee;
  }

  public List<Attendee> getAttendees()
  {
    List<Attendee> newAttendees = Collections.unmodifiableList(attendees);
    return newAttendees;
  }

  public int numberOfAttendees()
  {
    int number = attendees.size();
    return number;
  }

  public boolean hasAttendees()
  {
    boolean has = attendees.size() > 0;
    return has;
  }

  public int indexOfAttendee(Attendee aAttendee)
  {
    int index = attendees.indexOf(aAttendee);
    return index;
  }
  /* Code from template association_GetOne */
  public MarketingCampaign getMarketingCampaign()
  {
    return marketingCampaign;
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
      existingEvent.removeTicket(this);
    }
    event.addTicket(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAttendees()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addAttendee(Attendee aAttendee)
  {
    boolean wasAdded = false;
    if (attendees.contains(aAttendee)) { return false; }
    attendees.add(aAttendee);
    if (aAttendee.indexOfTicket(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAttendee.addTicket(this);
      if (!wasAdded)
      {
        attendees.remove(aAttendee);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeAttendee(Attendee aAttendee)
  {
    boolean wasRemoved = false;
    if (!attendees.contains(aAttendee))
    {
      return wasRemoved;
    }

    int oldIndex = attendees.indexOf(aAttendee);
    attendees.remove(oldIndex);
    if (aAttendee.indexOfTicket(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAttendee.removeTicket(this);
      if (!wasRemoved)
      {
        attendees.add(oldIndex,aAttendee);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAttendeeAt(Attendee aAttendee, int index)
  {  
    boolean wasAdded = false;
    if(addAttendee(aAttendee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAttendees()) { index = numberOfAttendees() - 1; }
      attendees.remove(aAttendee);
      attendees.add(index, aAttendee);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAttendeeAt(Attendee aAttendee, int index)
  {
    boolean wasAdded = false;
    if(attendees.contains(aAttendee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAttendees()) { index = numberOfAttendees() - 1; }
      attendees.remove(aAttendee);
      attendees.add(index, aAttendee);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAttendeeAt(aAttendee, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setMarketingCampaign(MarketingCampaign aMarketingCampaign)
  {
    boolean wasSet = false;
    if (aMarketingCampaign == null)
    {
      return wasSet;
    }

    MarketingCampaign existingMarketingCampaign = marketingCampaign;
    marketingCampaign = aMarketingCampaign;
    if (existingMarketingCampaign != null && !existingMarketingCampaign.equals(aMarketingCampaign))
    {
      existingMarketingCampaign.removeTicket(this);
    }
    marketingCampaign.addTicket(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Event placeholderEvent = event;
    this.event = null;
    if(placeholderEvent != null)
    {
      placeholderEvent.removeTicket(this);
    }
    ArrayList<Attendee> copyOfAttendees = new ArrayList<Attendee>(attendees);
    attendees.clear();
    for(Attendee aAttendee : copyOfAttendees)
    {
      aAttendee.removeTicket(this);
    }
    MarketingCampaign placeholderMarketingCampaign = marketingCampaign;
    this.marketingCampaign = null;
    if(placeholderMarketingCampaign != null)
    {
      placeholderMarketingCampaign.removeTicket(this);
    }
  }

  // line 110 "model.ump"
   public void generateTicket(){
    
  }

  // line 113 "model.ump"
   public void validateTicket(){
    
  }

  // line 116 "model.ump"
   public void getTicketDetails(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "ticketID" + ":" + getTicketID()+ "," +
            "type" + ":" + getType()+ "," +
            "qrCode" + ":" + getQrCode()+ "," +
            "status" + ":" + getStatus()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "event = "+(getEvent()!=null?Integer.toHexString(System.identityHashCode(getEvent())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "marketingCampaign = "+(getMarketingCampaign()!=null?Integer.toHexString(System.identityHashCode(getMarketingCampaign())):"null");
  }
}