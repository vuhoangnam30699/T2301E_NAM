package AlphaAirlines;

import java.time.LocalDate;

public class Booking {
    private String bookingId;
    private LocalDate departureDate;
    private int numberOfTickets;
    private double price;
    private String cabinType;
    private String destination;
    private double totalPrice;

    public Booking(String bookingId, LocalDate departureDate, int numberOfTickets, double price, String cabinType, String destination) {
        this.bookingId = bookingId;
        this.departureDate = departureDate;
        this.numberOfTickets = numberOfTickets;
        this.price = price;
        this.cabinType = cabinType;
        this.destination = destination;
        this.totalPrice = totalPrice();
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingID(String bookingID) {
        this.bookingId = bookingId;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCabinType() {
        return cabinType;
    }

    public void setCabinType(String cabinType) {
        this.cabinType = cabinType;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double totalPrice() {
        return numberOfTickets * price;
    }

    public void ticketConfirmation(){
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Departure Date: " + departureDate);
        System.out.println("Destination: " + destination);
        System.out.println("Number of tickets: " + numberOfTickets);
        System.out.println("Cabin type: " + cabinType);
        System.out.println("Price: " + price);
        System.out.println("Total Price: " + totalPrice);
    }


}
