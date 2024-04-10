import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TakeOffTimeSearch implements Search
{
    @Override//לבדוק בשאר החיפושים שinstancof הוא מתאים
    public List<Flight> search(Object condition, List<Airline> airlines) {
        if (!(condition instanceof Date))
        {
            throw new IllegalArgumentException("take off has to be date");
        }
        List<Flight> list = new ArrayList<>();
        for (Airline airline : airlines) {
            for (Flight flight : airline.getFlights()) {
                if (flight.getTakeOffTime().equals(condition)) {// לוודא שהסוג חיפוש מתאים
                    list.add(flight);
                }
            }
            list.addAll(search(condition,airline.getAirlines()));
        }
        return list;
    }

}
