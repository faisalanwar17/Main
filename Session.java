/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;
import java.util.*;

// line 66 "model.ump"
// line 245 "model.ump"
public class Session
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Session Attributes
  private String sessionID;
  private String name;
  private Date date;
  private String time;
  private String description;

  //Session Associations
  private Speaker speaker;
  private Event event;
  private List<Attendee> attendees;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Session(String aSessionID, String aName, Date aDate, String aTime, String aDescription, Speaker aSpeaker, Event aEvent)
  {
    sessionID = aSessionID;
    name = aName;
    date = aDate;
    time = aTime;
    description = aDescription;
    boolean didAddSpeaker = setSpeaker(aSpeaker);
    if (!didAddSpeaker)
    {
      throw new RuntimeException("Unable to create session due to speaker. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddEvent = setEvent(aEvent);
    if (!didAddEvent)
    {
      throw new RuntimeException("Unable to create session due to event. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    attendees = new ArrayList<Attendee>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSessionID(String aSessionID)
  {
    boolean wasSet = false;
    sessionID = aSessionID;
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

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime(String aTime)
  {
    boolean wasSet = false;
    time = aTime;
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

  public String getSessionID()
  {
    return sessionID;
  }

  public String getName()
  {
    return name;
  }

  public Date getDate()
  {
    return date;
  }

  public String getTime()
  {
    return time;
  }

  public String getDescription()
  {
    return description;
  }
  /* Code from template association_GetOne */
  public Speaker getSpeaker()
  {
    return speaker;
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
  /* Code from template association_SetOneToMany */
  public boolean setSpeaker(Speaker aSpeaker)
  {
    boolean wasSet = false;
    if (aSpeaker == null)
    {
      return wasSet;
    }

    Speaker existingSpeaker = speaker;
    speaker = aSpeaker;
    if (existingSpeaker != null && !existingSpeaker.equals(aSpeaker))
    {
      existingSpeaker.removeSession(this);
    }
    speaker.addSession(this);
    wasSet = true;
    return wasSet;
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
      existingEvent.removeSession(this);
    }
    event.addSession(this);
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
    if (aAttendee.indexOfSession(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAttendee.addSession(this);
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
    if (aAttendee.indexOfSession(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAttendee.removeSession(this);
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
    Speaker placeholderSpeaker = speaker;
    this.speaker = null;
    if(placeholderSpeaker != null)
    {
      placeholderSpeaker.removeSession(this);
    }
    Event placeholderEvent = event;
    this.event = null;
    if(placeholderEvent != null)
    {
      placeholderEvent.removeSession(this);
    }
    ArrayList<Attendee> copyOfAttendees = new ArrayList<Attendee>(attendees);
    attendees.clear();
    for(Attendee aAttendee : copyOfAttendees)
    {
      aAttendee.removeSession(this);
    }
  }

  // line 76 "model.ump"
   public void createSession(){
    
  }

  // line 79 "model.ump"
   public void updateSession(){
    
  }

  // line 82 "model.ump"
   public void getSessiondetails(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "sessionID" + ":" + getSessionID()+ "," +
            "name" + ":" + getName()+ "," +
            "time" + ":" + getTime()+ "," +
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "speaker = "+(getSpeaker()!=null?Integer.toHexString(System.identityHashCode(getSpeaker())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "event = "+(getEvent()!=null?Integer.toHexString(System.identityHashCode(getEvent())):"null");
  }
}