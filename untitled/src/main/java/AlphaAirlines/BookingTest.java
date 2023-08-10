package AlphaAirlines;

import java.time.LocalDate;

public class BookingTest {
    public static void main(String[] args) {
        Booking bookingA = new Booking("A12345", LocalDate.now(), 2, 5304.98, "First Class", "Tokyo");
        Booking bookingB = new Booking("B54321", LocalDate.of(2023, 7, 29), 1, 1028.80, "Business Class", "Singapore");

        bookingA.ticketConfirmation();
        System.out.println("\n-------------------------------\n");
        bookingB.ticketConfirmation();
    }
}
