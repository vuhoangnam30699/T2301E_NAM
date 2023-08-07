package Part2;

import java.time.ZonedDateTime;
import java.util.Objects;

public class OverseaFlight extends Flight {
    private Location destinationCity;
    private String destinationCountry;

    public OverseaFlight(int number, Location departureCity, String departureCountry, ZonedDateTime startTime, ZonedDateTime endTime, Location destinationCity, String destinationCountry) {
        super(number, departureCity, departureCountry, startTime, endTime);
        this.destinationCity = destinationCity;
        this.destinationCountry = destinationCountry;
    }

    public Location getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(Location destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public double calculatePrice(){
        double lon1 = this.getDepartureCity().getLongitude();
        double lon2 = this.getDestinationCity().getLongitude();
        double lat1 = this.getDepartureCity().getLatitude();
        double lat2 = this.getDestinationCity().getLatitude();

        Continent departureContinent = this.getDepartureCity().getContinent();
        Continent destinationContinent = this.getDestinationCity().getContinent();

        double distance = getDistance(lat1, lat2, lon1, lon2);
        double price;
        if(Objects.equals(destinationContinent, departureContinent)) {
            price = 1490  * distance;
        } else {
            price = 1780  * distance;
        }

        return price;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPrice:     " + calculatePrice();
    }
}
