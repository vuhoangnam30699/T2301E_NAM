package Part1;

import java.time.ZonedDateTime;

public class Flight {
    private int number;
    private String departureCity;
    private String departureCountry;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;

    public Flight() {
    }

    public Flight(int number, String departureCity, String departureCountry, ZonedDateTime startTime, ZonedDateTime endTime) {
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

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
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

    @Override
    public String toString() {
        return "Flight number:  " + number + "\nStart Time:     " + startTime + "\nEnd Time:       " + endTime + "\nDeparture:      "
                + departureCity + ", " + departureCountry;
    }
}
