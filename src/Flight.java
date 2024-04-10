import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Flight implements Subject{
    private final int idNumFlight; //cant be two flights with same number
    private int cost;
    private int timeFlightOnMinutes;
    private Date takeOffTime;
    private final String sourceAirport;
    private final String destinationAirport;
    private List<Person> personOnFlight = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private MessageFactory messageFactory;
    private final int passengerCapacity;
    private final int WorkerCapacity;
    private int amountPassenger=0;
    private int amountWorker=0;


    public Flight(int idNumFlight, int cost, int timeFlightOnMinutes, Date takeOffTime,
                  String sourceAirport, String destenationAirport,int WorkerCapacity,int passengerCapacity) {
        this.idNumFlight = idNumFlight;
        this.cost = cost;
        this.timeFlightOnMinutes = timeFlightOnMinutes;
        this.takeOffTime = takeOffTime;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destenationAirport;
        this.messageFactory = new MessageFactory(idNumFlight+"");
        this.passengerCapacity=passengerCapacity;
        this.WorkerCapacity=WorkerCapacity;
    }
    public void registerPassenger(Passenger p)
    {
        if(amountPassenger==passengerCapacity)
        {
            throw new RuntimeException("sorry flight is full next time you should register before");
        }
        amountPassenger++;
        personOnFlight.add(p);

    }
    public void registerWorker(Worker w)
    {
        if(amountWorker==WorkerCapacity)
        {
            throw new RuntimeException("sorry flight is full next time you should register before");
        }
        amountWorker++;
        personOnFlight.add(w);
    }
    public void unregisterPassenger(Passenger p)
    {
        amountPassenger--;
        personOnFlight.remove(p);
    }
    public void unregisterWorker(Worker w)
    {
        amountWorker--;
        personOnFlight.remove(w);
    }
    @Override
    public void registerObserver(Observer observer)
    {
        observers.add(observer);
    }
    @Override
    public void unregisterObserver(Observer observer)
    {
        observers.remove(observer);
    }


    @Override
    public void notifyObservers(String message)
    {
        for (int i = 0; i < observers.size(); i++)
        {
            observers.get(i).update(message);
        }
    }

    public int getIdNumFlight() {
        return idNumFlight;
    }

    public int getCost() {
        return cost;
    }

    public int getTimeFlightOnMinutes() {
        return timeFlightOnMinutes;
    }

    public Date getTakeOffTime() {
        return takeOffTime;
    }

    public int getNumberOfPassenger() {
        return personOnFlight.size();
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;

    }
//add notifyObservers for all the setters;!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void setTimeFlightOnMinutes(int timeFlightOnMinutes) {
        this.timeFlightOnMinutes = timeFlightOnMinutes;
    }

    public void setTakeOffTime(Date takeOffTime) {
        this.takeOffTime = takeOffTime;
    }

    public void setCost (int newCost)
    {
        notifyObservers(messageFactory.createMessage("costFlight",cost,newCost));
      this.cost = newCost;

    }

}