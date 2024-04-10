import java.util.ArrayList;
import java.util.List;

public class Airline
{
    private List<Airline> subairlines = new ArrayList<>();

    private List<Flight> flights = new ArrayList<>();
    private String nameOfAirline;
    private int revenues = 0;

    public Airline(String name)
    {
    this.nameOfAirline = name;
    }

    public int getOwnFlightRevenues() {
        return revenues;
    }
    public List<Flight> getFlights() {
        return flights;
    }
    public List<Airline> getAirlines() {
        return subairlines;
    }
    public int getTotalRevenues() {
        int sum = revenues;
        for (Airline airline : subairlines) {
            sum += airline.getTotalRevenues();
        }
        return sum;
    }

    public String getNameOfAirline() {
        return nameOfAirline;
    }
    public void setNameOfAirline(String nameOfAirline) {
        this.nameOfAirline = nameOfAirline;
    }

    public void addFlight(Flight f){
        flights.add(f);

    }
    public void removeFlight(Flight f){
        flights.remove(f);
    }
    public void addSubairline(Airline airline)
    {
        subairlines.add(airline);
    }
    public void removeSubairline(Airline airline)
    {
        subairlines.remove(airline);
    }
    public boolean registerPassenger(Passenger p, int flightId)
    {
        for (Flight flight : flights) {
            if (flight.getIdNumFlight() == flightId) {
                flight.registerPassenger(p);
                revenues += flight.getCost();
                return true;
            }
        }
        for (Airline airline : subairlines) {
            if (airline.registerPassenger(p,flightId)) {
                return true;
            }
        }
        return false;
    }

    public boolean unregisterPassenger(Passenger p, int flightId)
    {
        for (Flight flight : flights) {
            if (flight.getIdNumFlight() == flightId) {
                flight.unregisterPassenger(p);
                revenues -= flight.getCost();
                return true;
            }
        }
        for (Airline airline : subairlines) {
            if (airline.unregisterPassenger(p,flightId)) {
                return true;
            }
        }
        return false;
    }

}
