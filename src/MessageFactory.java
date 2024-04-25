import java.util.Date;

public class MessageFactory
{
    private final String flight;
    public MessageFactory(String flight) {
        this.flight = flight;
    }
     public String  createMessage(String type, Object original, Object updated)
     {
         //changetime
         if(type.equals("theTimeOfFlightChange")){
             if (!(original instanceof Date) || !(updated instanceof Date))
                 throw new IllegalArgumentException("change time message has to receive dates");
             return "The time of flight: " + flight + " was changed from: " + original + " to: " + updated;
         }
         if(type.equals("changeTakeOfTime")){
             if (!(original instanceof Date) || !(updated instanceof Date))
                 throw new IllegalArgumentException("change time message has to receive dates");
             return "Take off time of flight: " + flight + " was changed from: " + original + " to: " + updated;
         }
         if(type.equals("costFlight")){
             if (!(original instanceof Integer) || !(updated instanceof Integer))
                 throw new IllegalArgumentException("change time message has to receive dates");
             return "The price of flight: " + flight + " was changed from: " + original + " to: " + updated;
         }


         //add more if!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!



         throw new IllegalArgumentException("meassage type not supported!");

     }


}
