package Part2;

import java.time.ZonedDateTime;

public class Flight {
    private int number;
    private Location departureCity;
    private String departureCountry;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;

    public Flight() {
    }

    public Flight(int number, Location departureCity, String departureCountry, ZonedDateTime startTime, ZonedDateTime endTime) {
        this.number = number;
        this.departureCity = departureCity;
        this.departureCountry = departureCountry;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Location getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(Location departureCity) {
        this.departureCity = departureCity;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public double getDistance(double lat1, double lat2, double lon1, double lon2) {

        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        double r = 6371;

        return (c * r);
    }

    @Override
    public String toString() {
        return "Flight number:  " + number + "\nStart Time:     " + startTime + "\nEnd Time:       " + endTime + "\nDeparture:      "
                + departureCity + ", " + departureCountry;
    }
}