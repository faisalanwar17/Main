/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;

// line 139 "model.ump"
// line 269 "model.ump"
public class Venue
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Venue Attributes
  private String venueID;
  private String name;
  private String address;
  private String capacity;

  //Venue Associations
  private Event event;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Venue(String aVenueID, String aName, String aAddress, String aCapacity, Event aEvent)
  {
    venueID = aVenueID;
    name = aName;
    address = aAddress;
    capacity = aCapacity;
    if (aEvent == null || aEvent.getVenue() != null)
    {
      throw new RuntimeException("Unable to create Venue due to aEvent. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    event = aEvent;
  }

  public Venue(String aVenueID, String aName, String aAddress, String aCapacity, String aEventIDForEvent, String aDescriptionForEvent, Date aDateForEvent, Date aTimeForEvent, String aVenueNameForEvent, String aTypeForEvent)
  {
    venueID = aVenueID;
    name = aName;
    address = aAddress;
    capacity = aCapacity;
    event = new Event(aEventIDForEvent, aDescriptionForEvent, aDateForEvent, aTimeForEvent, aVenueNameForEvent, aTypeForEvent, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setVenueID(String aVenueID)
  {
    boolean wasSet = false;
    venueID = aVenueID;
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

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setCapacity(String aCapacity)
  {
    boolean wasSet = false;
    capacity = aCapacity;
    wasSet = true;
    return wasSet;
  }

  public String getVenueID()
  {
    return venueID;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public String getCapacity()
  {
    return capacity;
  }
  /* Code from template association_GetOne */
  public Event getEvent()
  {
    return event;
  }

  public void delete()
  {
    Event existingEvent = event;
    event = null;
    if (existingEvent != null)
    {
      existingEvent.delete();
    }
  }

  // line 147 "model.ump"
   public void createVenue(){
    
  }

  // line 150 "model.ump"
   public void updateVenue(){
    
  }

  // line 153 "model.ump"
   public void getVenueDetails(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "venueID" + ":" + getVenueID()+ "," +
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "," +
            "capacity" + ":" + getCapacity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "event = "+(getEvent()!=null?Integer.toHexString(System.identityHashCode(getEvent())):"null");
  }
}