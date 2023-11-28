/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 85 "model.ump"
// line 251 "model.ump"
public class Vendor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Vendor Attributes
  private String vendorID;
  private String name;
  private int boothNumber;
  private String description;

  //Vendor Associations
  private Event event;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Vendor(String aVendorID, String aName, int aBoothNumber, String aDescription, Event aEvent)
  {
    vendorID = aVendorID;
    name = aName;
    boothNumber = aBoothNumber;
    description = aDescription;
    boolean didAddEvent = setEvent(aEvent);
    if (!didAddEvent)
    {
      throw new RuntimeException("Unable to create vendor due to event. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setVendorID(String aVendorID)
  {
    boolean wasSet = false;
    vendorID = aVendorID;
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

  public boolean setBoothNumber(int aBoothNumber)
  {
    boolean wasSet = false;
    boothNumber = aBoothNumber;
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

  public String getVendorID()
  {
    return vendorID;
  }

  public String getName()
  {
    return name;
  }

  public int getBoothNumber()
  {
    return boothNumber;
  }

  public String getDescription()
  {
    return description;
  }
  /* Code from template association_GetOne */
  public Event getEvent()
  {
    return event;
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
      existingEvent.removeVendor(this);
    }
    event.addVendor(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Event placeholderEvent = event;
    this.event = null;
    if(placeholderEvent != null)
    {
      placeholderEvent.removeVendor(this);
    }
  }

  // line 93 "model.ump"
   public void registerVendorForEvent(){
    
  }

  // line 96 "model.ump"
   public void updateVendorDetails(){
    
  }

  // line 99 "model.ump"
   public void getVendorDetails(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "vendorID" + ":" + getVendorID()+ "," +
            "name" + ":" + getName()+ "," +
            "boothNumber" + ":" + getBoothNumber()+ "," +
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "event = "+(getEvent()!=null?Integer.toHexString(System.identityHashCode(getEvent())):"null");
  }
}