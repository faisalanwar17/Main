/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 156 "model.ump"
// line 274 "model.ump"
public class Speaker
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Speaker Attributes
  private String speakerID;
  private String name;
  private String bio;
  private long contact;

  //Speaker Associations
  private List<Session> sessions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Speaker(String aSpeakerID, String aName, String aBio, long aContact)
  {
    speakerID = aSpeakerID;
    name = aName;
    bio = aBio;
    contact = aContact;
    sessions = new ArrayList<Session>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSpeakerID(String aSpeakerID)
  {
    boolean wasSet = false;
    speakerID = aSpeakerID;
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

  public boolean setBio(String aBio)
  {
    boolean wasSet = false;
    bio = aBio;
    wasSet = true;
    return wasSet;
  }

  public boolean setContact(long aContact)
  {
    boolean wasSet = false;
    contact = aContact;
    wasSet = true;
    return wasSet;
  }

  public String getSpeakerID()
  {
    return speakerID;
  }

  public String getName()
  {
    return name;
  }

  public String getBio()
  {
    return bio;
  }

  public long getContact()
  {
    return contact;
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
  public static int minimumNumberOfSessions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Session addSession(String aSessionID, String aName, Date aDate, String aTime, String aDescription, Event aEvent)
  {
    return new Session(aSessionID, aName, aDate, aTime, aDescription, this, aEvent);
  }

  public boolean addSession(Session aSession)
  {
    boolean wasAdded = false;
    if (sessions.contains(aSession)) { return false; }
    Speaker existingSpeaker = aSession.getSpeaker();
    boolean isNewSpeaker = existingSpeaker != null && !this.equals(existingSpeaker);
    if (isNewSpeaker)
    {
      aSession.setSpeaker(this);
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
    //Unable to remove aSession, as it must always have a speaker
    if (!this.equals(aSession.getSpeaker()))
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

  public void delete()
  {
    for(int i=sessions.size(); i > 0; i--)
    {
      Session aSession = sessions.get(i - 1);
      aSession.delete();
    }
  }

  // line 164 "model.ump"
   public void createSpeaker(){
    
  }

  // line 167 "model.ump"
   public void updateSpeaker(){
    
  }

  // line 170 "model.ump"
   public void getSpeakerDetails(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "speakerID" + ":" + getSpeakerID()+ "," +
            "name" + ":" + getName()+ "," +
            "bio" + ":" + getBio()+ "," +
            "contact" + ":" + getContact()+ "]";
  }
}