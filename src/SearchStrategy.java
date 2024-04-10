import java.util.List;

public class SearchStrategy {
    private Search typeOfSearch;

    public void set(String type)
    {
        if (type.equals("TakeOffTime")) {
            typeOfSearch = new TakeOffTimeSearch();
        } //else if (type.equals())//הוספה של פאקטורי
    }
    public List<Flight> search(Object condition, List<Airline> airlines ) {
        if(typeOfSearch==null){
            throw new NullPointerException("no type of search selected");
        }
        return typeOfSearch.search(condition,airlines);
    }

}
