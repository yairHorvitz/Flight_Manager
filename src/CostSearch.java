import java.util.ArrayList;
import java.util.List;
public class CostSearch implements Search
{
    @Override
    public List<Flight> search(Object condition, List<Airline> airlines) {
        if (!(condition instanceof Integer))
        {
            throw new IllegalArgumentException("the cost has to be integer");
        }
        List<Flight> list = new ArrayList<>();
        for (Airline airline : airlines) {
            for (Flight flight : airline.getFlights()) {
                if (flight.getCost()==(int)condition) {// לוודא שהסוג חיפוש מתאים
                    list.add(flight);
                }
            }
            list.addAll(search(condition,airline.getAirlines()));
        }
        return list;
    }
}
