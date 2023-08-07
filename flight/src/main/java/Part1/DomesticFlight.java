package Part1;

import java.time.ZonedDateTime;

public class DomesticFlight extends Flight {
    private String destinationCity;

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public DomesticFlight(int number, String departureCity, String departureCountry, ZonedDateTime startTime, ZonedDateTime endTime, String destinationCity) {
        super(number, departureCity, departureCountry, startTime, endTime);
        this.destinationCity = destinationCity;


    }

    @Override
    public String toString() {
        return super.toString() + "\nDestination:    " + destinationCity + ", Vietnam";
    }
}
