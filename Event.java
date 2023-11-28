/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;
import java.util.*;

// line 2 "model.ump"
// line 220 "model.ump"
public class Event
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Event Attributes
  private String eventID;
  private String description;
  private Date date;
  private Date time;
  private String venueName;
  private String type;

  //Event Associations
  private List<TicketType> ticketTypes;
  private List<Session> sessions;
  private List<MarketingCampaign> marketingCampaigns;
  private Venue venue;
  private List<Vendor> vendors;
  private List<Ticket> tickets;
  private List<Attendee> attendees;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Event(String aEventID, String aDescription, Date aDate, Date aTime, String aVenueName, String aType, Venue aVenue)
  {
    eventID = aEventID;
    description = aDescription;
    date = aDate;
    time = aTime;
    venueName = aVenueName;
    type = aType;
    ticketTypes = new ArrayList<TicketType>();
    sessions = new ArrayList<Session>();
    marketingCampaigns = new ArrayList<MarketingCampaign>();
    if (aVenue == null || aVenue.getEvent() != null)
    {
      throw new RuntimeException("Unable to create Event due to aVenue. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    venue = aVenue;
    vendors = new ArrayList<Vendor>();
    tickets = new ArrayList<Ticket>();
    attendees = new ArrayList<Attendee>();
  }

  public Event(String aEventID, String aDescription, Date aDate, Date aTime, String aVenueName, String aType, String aVenueIDForVenue, String aNameForVenue, String aAddressForVenue, String aCapacityForVenue)
  {
    eventID = aEventID;
    description = aDescription;
    date = aDate;
    time = aTime;
    venueName = aVenueName;
    type = aType;
    ticketTypes = new ArrayList<TicketType>();
    sessions = new ArrayList<Session>();
    marketingCampaigns = new ArrayList<MarketingCampaign>();
    venue = new Venue(aVenueIDForVenue, aNameForVenue, aAddressForVenue, aCapacityForVenue, this);
    vendors = new ArrayList<Vendor>();
    tickets = new ArrayList<Ticket>();
    attendees = new ArrayList<Attendee>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setEventID(String aEventID)
  {
    boolean wasSet = false;
    eventID = aEventID;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime(Date aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setVenueName(String aVenueName)
  {
    boolean wasSet = false;
    venueName = aVenueName;
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

  public String getEventID()
  {
    return eventID;
  }

  public String getDescription()
  {
    return description;
  }

  public Date getDate()
  {
    return date;
  }

  public Date getTime()
  {
    return time;
  }

  public String getVenueName()
  {
    return venueName;
  }

  public String getType()
  {
    return type;
  }
  /* Code from template association_GetMany */
  public TicketType getTicketType(int index)
  {
    TicketType aTicketType = ticketTypes.get(index);
    return aTicketType;
  }

  public List<TicketType> getTicketTypes()
  {
    List<TicketType> newTicketTypes = Collections.unmodifiableList(ticketTypes);
    return newTicketTypes;
  }

  public int numberOfTicketTypes()
  {
    int number = ticketTypes.size();
    return number;
  }

  public boolean hasTicketTypes()
  {
    boolean has = ticketTypes.size() > 0;
    return has;
  }

  public int indexOfTicketType(TicketType aTicketType)
  {
    int index = ticketTypes.indexOf(aTicketType);
    return index;
  }
  /* Code from template association_GetMany */
  public Session getSession(int index)
  {
    Session aSession = sessions.get(index);
    return aSession;
  }

  public List<Session> getSessions()
  {
    List<Session> newSessions = Collections.unmodifiableList(sessions);
    return newSessions;
  }

  public int numberOfSessions()
  {
    int number = sessions.size();
    return number;
  }

  public boolean hasSessions()
  {
    boolean has = sessions.size() > 0;
    return has;
  }

  public int indexOfSession(Session aSession)
  {
    int index = sessions.indexOf(aSession);
    return index;
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
  public Venue getVenue()
  {
    return venue;
  }
  /* Code from template association_GetMany */
  public Vendor getVendor(int index)
  {
    Vendor aVendor = vendors.get(index);
    return aVendor;
  }

  public List<Vendor> getVendors()
  {
    List<Vendor> newVendors = Collections.unmodifiableList(vendors);
    return newVendors;
  }

  public int numberOfVendors()
  {
    int number = vendors.size();
    return number;
  }

  public boolean hasVendors()
  {
    boolean has = vendors.size() > 0;
    return has;
  }

  public int indexOfVendor(Vendor aVendor)
  {
    int index = vendors.indexOf(aVendor);
    return index;
  }
  /* Code from template association_GetMany */
  public Ticket getTicket(int index)
  {
    Ticket aTicket = tickets.get(index);
    return aTicket;
  }

  public List<Ticket> getTickets()
  {
    List<Ticket> newTickets = Collections.unmodifiableList(tickets);
    return newTickets;
  }

  public int numberOfTickets()
  {
    int number = tickets.size();
    return number;
  }

  public boolean hasTickets()
  {
    boolean has = tickets.size() > 0;
    return has;
  }

  public int indexOfTicket(Ticket aTicket)
  {
    int index = tickets.indexOf(aTicket);
    return index;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTicketTypes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public TicketType addTicketType(String aTypeID, String aName, int aPrice, int aAvailability)
  {
    return new TicketType(aTypeID, aName, aPrice, aAvailability, this);
  }

  public boolean addTicketType(TicketType aTicketType)
  {
    boolean wasAdded = false;
    if (ticketTypes.contains(aTicketType)) { return false; }
    Event existingEvent = aTicketType.getEvent();
    boolean isNewEvent = existingEvent != null && !this.equals(existingEvent);
    if (isNewEvent)
    {
      aTicketType.setEvent(this);
    }
    else
    {
      ticketTypes.add(aTicketType);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTicketType(TicketType aTicketType)
  {
    boolean wasRemoved = false;
    //Unable to remove aTicketType, as it must always have a event
    if (!this.equals(aTicketType.getEvent()))
    {
      ticketTypes.remove(aTicketType);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTicketTypeAt(TicketType aTicketType, int index)
  {  
    boolean wasAdded = false;
    if(addTicketType(aTicketType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTicketTypes()) { index = numberOfTicketTypes() - 1; }
      ticketTypes.remove(aTicketType);
      ticketTypes.add(index, aTicketType);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTicketTypeAt(TicketType aTicketType, int index)
  {
    boolean wasAdded = false;
    if(ticketTypes.contains(aTicketType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTicketTypes()) { index = numberOfTicketTypes() - 1; }
      ticketTypes.remove(aTicketType);
      ticketTypes.add(index, aTicketType);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTicketTypeAt(aTicketType, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSessions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Session addSession(String aSessionID, String aName, Date aDate, String aTime, String aDescription, Speaker aSpeaker)
  {
    return new Session(aSessionID, aName, aDate, aTime, aDescription, aSpeaker, this);
  }

  public boolean addSession(Session aSession)
  {
    boolean wasAdded = false;
    if (sessions.contains(aSession)) { return false; }
    Event existingEvent = aSession.getEvent();
    boolean isNewEvent = existingEvent != null && !this.equals(existingEvent);
    if (isNewEvent)
    {
      aSession.setEvent(this);
    }
    else
    {
      sessions.add(aSession);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSession(Session aSession)
  {
    boolean wasRemoved = false;
    //Unable to remove aSession, as it must always have a event
    if (!this.equals(aSession.getEvent()))
    {
      sessions.remove(aSession);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSessionAt(Session aSession, int index)
  {  
    boolean wasAdded = false;
    if(addSession(aSession))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSessions()) { index = numberOfSessions() - 1; }
      sessions.remove(aSession);
      sessions.add(index, aSession);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSessionAt(Session aSession, int index)
  {
    boolean wasAdded = false;
    if(sessions.contains(aSession))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSessions()) { index = numberOfSessions() - 1; }
      sessions.remove(aSession);
      sessions.add(index, aSession);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSessionAt(aSession, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMarketingCampaigns()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public MarketingCampaign addMarketingCampaign(String aCampaignID, String aName, Date aStartDate, Date aEndDate)
  {
    return new MarketingCampaign(aCampaignID, aName, aStartDate, aEndDate, this);
  }

  public boolean addMarketingCampaign(MarketingCampaign aMarketingCampaign)
  {
    boolean wasAdded = false;
    if (marketingCampaigns.contains(aMarketingCampaign)) { return false; }
    Event existingEvent = aMarketingCampaign.getEvent();
    boolean isNewEvent = existingEvent != null && !this.equals(existingEvent);
    if (isNewEvent)
    {
      aMarketingCampaign.setEvent(this);
    }
    else
    {
      marketingCampaigns.add(aMarketingCampaign);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMarketingCampaign(MarketingCampaign aMarketingCampaign)
  {
    boolean wasRemoved = false;
    //Unable to remove aMarketingCampaign, as it must always have a event
    if (!this.equals(aMarketingCampaign.getEvent()))
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfVendors()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Vendor addVendor(String aVendorID, String aName, int aBoothNumber, String aDescription)
  {
    return new Vendor(aVendorID, aName, aBoothNumber, aDescription, this);
  }

  public boolean addVendor(Vendor aVendor)
  {
    boolean wasAdded = false;
    if (vendors.contains(aVendor)) { return false; }
    Event existingEvent = aVendor.getEvent();
    boolean isNewEvent = existingEvent != null && !this.equals(existingEvent);
    if (isNewEvent)
    {
      aVendor.setEvent(this);
    }
    else
    {
      vendors.add(aVendor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVendor(Vendor aVendor)
  {
    boolean wasRemoved = false;
    //Unable to remove aVendor, as it must always have a event
    if (!this.equals(aVendor.getEvent()))
    {
      vendors.remove(aVendor);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addVendorAt(Vendor aVendor, int index)
  {  
    boolean wasAdded = false;
    if(addVendor(aVendor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVendors()) { index = numberOfVendors() - 1; }
      vendors.remove(aVendor);
      vendors.add(index, aVendor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVendorAt(Vendor aVendor, int index)
  {
    boolean wasAdded = false;
    if(vendors.contains(aVendor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVendors()) { index = numberOfVendors() - 1; }
      vendors.remove(aVendor);
      vendors.add(index, aVendor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVendorAt(aVendor, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTickets()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Ticket addTicket(String aTicketID, String aType, String aQrCode, String aStatus, MarketingCampaign aMarketingCampaign)
  {
    return new Ticket(aTicketID, aType, aQrCode, aStatus, this, aMarketingCampaign);
  }

  public boolean addTicket(Ticket aTicket)
  {
    boolean wasAdded = false;
    if (tickets.contains(aTicket)) { return false; }
    Event existingEvent = aTicket.getEvent();
    boolean isNewEvent = existingEvent != null && !this.equals(existingEvent);
    if (isNewEvent)
    {
      aTicket.setEvent(this);
    }
    else
    {
      tickets.add(aTicket);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTicket(Ticket aTicket)
  {
    boolean wasRemoved = false;
    //Unable to remove aTicket, as it must always have a event
    if (!this.equals(aTicket.getEvent()))
    {
      tickets.remove(aTicket);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTicketAt(Ticket aTicket, int index)
  {  
    boolean wasAdded = false;
    if(addTicket(aTicket))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTickets()) { index = numberOfTickets() - 1; }
      tickets.remove(aTicket);
      tickets.add(index, aTicket);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTicketAt(Ticket aTicket, int index)
  {
    boolean wasAdded = false;
    if(tickets.contains(aTicket))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTickets()) { index = numberOfTickets() - 1; }
      tickets.remove(aTicket);
      tickets.add(index, aTicket);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTicketAt(aTicket, index);
    }
    return wasAdded;
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
    if (aAttendee.indexOfEvent(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAttendee.addEvent(this);
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
    if (aAttendee.indexOfEvent(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAttendee.removeEvent(this);
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

  public void delete()
  {
    for(int i=ticketTypes.size(); i > 0; i--)
    {
      TicketType aTicketType = ticketTypes.get(i - 1);
      aTicketType.delete();
    }
    while (sessions.size() > 0)
    {
      Session aSession = sessions.get(sessions.size() - 1);
      aSession.delete();
      sessions.remove(aSession);
    }
    
    for(int i=marketingCampaigns.size(); i > 0; i--)
    {
      MarketingCampaign aMarketingCampaign = marketingCampaigns.get(i - 1);
      aMarketingCampaign.delete();
    }
    Venue existingVenue = venue;
    venue = null;
    if (existingVenue != null)
    {
      existingVenue.delete();
    }
    while (vendors.size() > 0)
    {
      Vendor aVendor = vendors.get(vendors.size() - 1);
      aVendor.delete();
      vendors.remove(aVendor);
    }
    
    for(int i=tickets.size(); i > 0; i--)
    {
      Ticket aTicket = tickets.get(i - 1);
      aTicket.delete();
    }
    ArrayList<Attendee> copyOfAttendees = new ArrayList<Attendee>(attendees);
    attendees.clear();
    for(Attendee aAttendee : copyOfAttendees)
    {
      aAttendee.removeEvent(this);
    }
  }

  // line 18 "model.ump"
   private void createEvent(){
    
  }

  // line 21 "model.ump"
   public void cancelEvent(){
    
  }

  // line 24 "model.ump"
   public void getEvent(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "eventID" + ":" + getEventID()+ "," +
            "description" + ":" + getDescription()+ "," +
            "venueName" + ":" + getVenueName()+ "," +
            "type" + ":" + getType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "time" + "=" + (getTime() != null ? !getTime().equals(this)  ? getTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "venue = "+(getVenue()!=null?Integer.toHexString(System.identityHashCode(getVenue())):"null");
  }
}