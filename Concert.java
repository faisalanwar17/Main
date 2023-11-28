/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;
import java.util.*;

// line 206 "model.ump"
// line 297 "model.ump"
public class Concert extends Event
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Concert(String aEventID, String aDescription, Date aDate, Date aTime, String aVenueName, String aType, Venue aVenue)
  {
    super(aEventID, aDescription, aDate, aTime, aVenueName, aType, aVenue);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

  // line 210 "model.ump"
   public void createEvent(){
    
  }

  // line 213 "model.ump"
   public void cancelEvent(){
    
  }

  // line 216 "model.ump"
   public void getEvent(){
    
  }

}