import java.util.Date;
import java.util.List;

public class main {

    public static void main(String[] args) {
        FlightsSystem flightsSystem = FlightsSystem.getInstance();

        Airline a1 = new Airline("a1");
        Airline a2 = new Airline("a2");
        Airline a3 = new Airline("a3");
        Airline a4 = new Airline("a4");
        a1.addSubairline(a2);
        a2.addSubairline(a3);
        a1.addSubairline(a4);

        Airline b1 = new Airline("b1");
        Airline b2 = new Airline("b2");
        Airline b3 = new Airline("b3");
        Airline b4 = new Airline("b4");
        b1.addSubairline(b3);
        b3.addSubairline(b2);
        b3.addSubairline(b4);

        flightsSystem.addAirline(a1);
        flightsSystem.addAirline(b1);

        flightsSystem.printRevenues();

        Date d = new Date();
        Flight f1 = new Flight(1,30,100,d,
                "tel aviv","frankfurt",10,100);
        a1.addFlight(f1);
        a2.addFlight(new Flight(2,30,100,d,
                "tel aviv","frankfurt",10,100));

        Passenger p1 = new Passenger(1,"bob",3,"male");
        Passenger p2 = new Passenger(2,"alice",3,"female");

        List<Flight> list = flightsSystem.search("TakeOffTime",d);
        System.out.println(list.get(0).getIdNumFlight());
        System.out.println(list.get(1).getIdNumFlight());

        flightsSystem.registerPassenger(p1,list.get(0).getIdNumFlight());
        flightsSystem.registerPassenger(p2,list.get(1).getIdNumFlight());

        flightsSystem.printRevenues();
        System.out.println("company a1 alone made: " + a1.getOwnFlightRevenues()+"$");

        flightsSystem.unregisterPassenger(p1,1);
        f1.registerObserver(p1);
        f1.registerObserver(p2);
        f1.setCost(50);
        flightsSystem.registerPassenger(p2,1);
        flightsSystem.printRevenues();
    }

}
