package Part1;

import java.time.ZonedDateTime;

public class OverseaFlight extends Flight {
    private String destinationCity;
    private String destinationCountry;

    public OverseaFlight(int number, String departureCity, String departureCountry, ZonedDateTime startTime, ZonedDateTime endTime, String destinationCity, String destinationCountry) {
        super(number, departureCity, departureCountry, startTime, endTime);
        this.destinationCity = destinationCity;
        this.destinationCountry = destinationCountry;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDestination:    " + destinationCity + ", " + destinationCountry;
    }
}
