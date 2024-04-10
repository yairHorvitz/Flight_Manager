public class Worker extends Person {
    private int countFlights;
    private int salary;
    private int[] arrPersonFlights; // This should be resized dynamically based on actual flights, not fixed to size 1

    public Worker(int id, String name, int age, String gender, int countFlights, int salary) {
        super(id ,name, age, gender);
        this.countFlights = countFlights;
        this.salary = salary;
        this.arrPersonFlights = new int[countFlights]; // Initialize the array with the specified count of flights
    }

    // Getters and setters for countFlights and salary
    public int getCountFlights() {
        return countFlights;
    }

    public void setCountFlights(int countFlights) {
        this.countFlights = countFlights;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Method to print "Hello, World"
    public void printHelloWorld() {
        System.out.println("Hello, World");
    }
}