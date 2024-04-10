
import java.util.ArrayList;
import java.util.List;

//built a system that get all the flights that have only one instance by singleton mayby i dont need it and i can to create it like a field
public class FlightsSystem {
        private final SearchStrategy searchStrategy = new SearchStrategy();
        private static FlightsSystem instance;
        private ArrayList<Airline> airlines;

        private FlightsSystem() {
            airlines = new ArrayList<>();
        }

        public static FlightsSystem getInstance() {
            if (instance == null) {
                instance = new FlightsSystem();
            }
            return instance;
        }

        public List<Flight> search(String searchType, Object condition) {
            searchStrategy.set(searchType);
            return searchStrategy.search(condition,airlines);
        }

    public boolean registerPassenger(Passenger p, int flightId)
    {
        for (Airline airline : airlines) {
            if (airline.registerPassenger(p,flightId)) {
                return true;
            }
        }
        return false;
    }

    public boolean unregisterPassenger(Passenger p, int flightId)
    {
        for (Airline airline : airlines) {
            if (airline.unregisterPassenger(p,flightId)) {
                return true;
            }
        }
        return false;
    }

        public void printRevenues() {
            for (Airline airline : airlines) {
                System.out.println(airline.getNameOfAirline() + " has made: " + airline.getTotalRevenues() + "$");
            }
        }

        public void addAirline(Airline airline) {
            airlines.add(airline);
        }

        public void removeAirline(Airline airline) {
            airlines.remove(airline);
        }

        public ArrayList<Airline> getAllAirlines() {
            return airlines;
        }
    }


