package Part2;

import java.time.ZonedDateTime;

public class DomesticFlight extends Flight {
    private Location destinationCity;

    public DomesticFlight(int number, Location departureCity, String departureCountry, ZonedDateTime startTime, ZonedDateTime endTime, Location destinationCity) {
        super(number, departureCity, departureCountry, startTime, endTime);
        this.destinationCity = destinationCity;
    }

    public Location getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(Location destinationCity) {
        this.destinationCity = destinationCity;
    }

    public double calculatePrice(){
        double lon1 = this.getDepartureCity().getLongitude();
        double lon2 = this.getDestinationCity().getLongitude();
        double lat1 = this.getDepartureCity().getLatitude();
        double lat2 = this.getDestinationCity().getLatitude();

        double price = 1120 * getDistance(lat1, lat2, lon1, lon2);

        return price;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPrice:     " + calculatePrice();
    }
}
