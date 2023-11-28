/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;
import java.util.*;

// line 192 "model.ump"
// line 292 "model.ump"
public class Conference extends Event
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Conference(String aEventID, String aDescription, Date aDate, Date aTime, String aVenueName, String aType, Venue aVenue)
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

  // line 196 "model.ump"
   public void createEvent(){
    
  }

  // line 199 "model.ump"
   public void cancelEvent(){
    
  }

  // line 202 "model.ump"
   public void getEvent(){
    
  }

}