/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 46 "model.ump"
// line 237 "model.ump"
public class Attendee
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Attendee Attributes
  private String attendeeID;
  private String name;
  private String email;
  private long contactNumber;

  //Attendee Associations
  private List<Event> events;
  private List<Ticket> tickets;
  private List<Session> sessions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Attendee(String aAttendeeID, String aName, String aEmail, long aContactNumber)
  {
    attendeeID = aAttendeeID;
    name = aName;
    email = aEmail;
    contactNumber = aContactNumber;
    events = new ArrayList<Event>();
    tickets = new ArrayList<Ticket>();
    sessions = new ArrayList<Session>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAttendeeID(String aAttendeeID)
  {
    boolean wasSet = false;
    attendeeID = aAttendeeID;
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

  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public boolean setContactNumber(long aContactNumber)
  {
    boolean wasSet = false;
    contactNumber = aContactNumber;
    wasSet = true;
    return wasSet;
  }

  public String getAttendeeID()
  {
    return attendeeID;
  }

  public String getName()
  {
    return name;
  }

  public String getEmail()
  {
    return email;
  }

  public long getContactNumber()
  {
    return contactNumber;
  }
  /* Code from template association_GetMany */
  public Event getEvent(int index)
  {
    Event aEvent = events.get(index);
    return aEvent;
  }

  public List<Event> getEvents()
  {
    List<Event> newEvents = Collections.unmodifiableList(events);
    return newEvents;
  }

  public int numberOfEvents()
  {
    int number = events.size();
    return number;
  }

  public boolean hasEvents()
  {
    boolean has = events.size() > 0;
    return has;
  }

  public int indexOfEvent(Event aEvent)
  {
    int index = events.indexOf(aEvent);
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEvents()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addEvent(Event aEvent)
  {
    boolean wasAdded = false;
    if (events.contains(aEvent)) { return false; }
    events.add(aEvent);
    if (aEvent.indexOfAttendee(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aEvent.addAttendee(this);
      if (!wasAdded)
      {
        events.remove(aEvent);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeEvent(Event aEvent)
  {
    boolean wasRemoved = false;
    if (!events.contains(aEvent))
    {
      return wasRemoved;
    }

    int oldIndex = events.indexOf(aEvent);
    events.remove(oldIndex);
    if (aEvent.indexOfAttendee(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aEvent.removeAttendee(this);
      if (!wasRemoved)
      {
        events.add(oldIndex,aEvent);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addEventAt(Event aEvent, int index)
  {  
    boolean wasAdded = false;
    if(addEvent(aEvent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEvents()) { index = numberOfEvents() - 1; }
      events.remove(aEvent);
      events.add(index, aEvent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEventAt(Event aEvent, int index)
  {
    boolean wasAdded = false;
    if(events.contains(aEvent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEvents()) { index = numberOfEvents() - 1; }
      events.remove(aEvent);
      events.add(index, aEvent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEventAt(aEvent, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTickets()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTicket(Ticket aTicket)
  {
    boolean wasAdded = false;
    if (tickets.contains(aTicket)) { return false; }
    tickets.add(aTicket);
    if (aTicket.indexOfAttendee(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTicket.addAttendee(this);
      if (!wasAdded)
      {
        tickets.remove(aTicket);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeTicket(Ticket aTicket)
  {
    boolean wasRemoved = false;
    if (!tickets.contains(aTicket))
    {
      return wasRemoved;
    }

    int oldIndex = tickets.indexOf(aTicket);
    tickets.remove(oldIndex);
    if (aTicket.indexOfAttendee(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTicket.removeAttendee(this);
      if (!wasRemoved)
      {
        tickets.add(oldIndex,aTicket);
      }
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
  public static int minimumNumberOfSessions()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addSession(Session aSession)
  {
    boolean wasAdded = false;
    if (sessions.contains(aSession)) { return false; }
    sessions.add(aSession);
    if (aSession.indexOfAttendee(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSession.addAttendee(this);
      if (!wasAdded)
      {
        sessions.remove(aSession);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeSession(Session aSession)
  {
    boolean wasRemoved = false;
    if (!sessions.contains(aSession))
    {
      return wasRemoved;
    }

    int oldIndex = sessions.indexOf(aSession);
    sessions.remove(oldIndex);
    if (aSession.indexOfAttendee(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSession.removeAttendee(this);
      if (!wasRemoved)
      {
        sessions.add(oldIndex,aSession);
      }
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

  public void delete()
  {
    ArrayList<Event> copyOfEvents = new ArrayList<Event>(events);
    events.clear();
    for(Event aEvent : copyOfEvents)
    {
      aEvent.removeAttendee(this);
    }
    ArrayList<Ticket> copyOfTickets = new ArrayList<Ticket>(tickets);
    tickets.clear();
    for(Ticket aTicket : copyOfTickets)
    {
      aTicket.removeAttendee(this);
    }
    ArrayList<Session> copyOfSessions = new ArrayList<Session>(sessions);
    sessions.clear();
    for(Session aSession : copyOfSessions)
    {
      aSession.removeAttendee(this);
    }
  }

  // line 57 "model.ump"
   public void registerForEvent(){
    
  }

  // line 60 "model.ump"
   public void purchaseTicket(){
    
  }

  // line 63 "model.ump"
   public void attendSession(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "attendeeID" + ":" + getAttendeeID()+ "," +
            "name" + ":" + getName()+ "," +
            "email" + ":" + getEmail()+ "," +
            "contactNumber" + ":" + getContactNumber()+ "]";
  }
}