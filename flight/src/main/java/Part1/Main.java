package Part1;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = List.of(
                new DomesticFlight(
                        1,
                        "Hanoi",
                        "Vietnam",
                        ZonedDateTime.of(2023, 8, 5, 8, 0, 0, 0, ZoneId.of("Asia/Bangkok")),
                        ZonedDateTime.of(2023, 8, 5, 10, 0, 0, 0, ZoneId.of("Asia/Bangkok")),
                        "Ho Chi Minh City"),
                new DomesticFlight(
                        2,
                        "Ho Chi Minh City",
                        "Vietnam",
                        ZonedDateTime.of(2023, 8, 4, 8, 0, 0, 0, ZoneId.of("Asia/Ho_Chi_Minh")),
                        ZonedDateTime.of(2023, 8, 4, 10, 0, 0, 0, ZoneId.of("Asia/Ho_Chi_Minh")),
                        "Hanoi"),
                new OverseaFlight(
                        3,
                        "Hanoi",
                        "Vietnam",
                        ZonedDateTime.of(2023, 8, 4, 14, 0, 0, 0, ZoneId.of("Asia/Ho_Chi_Minh")),
                        ZonedDateTime.of(2023, 8, 5, 4, 0, 0, 0, ZoneId.of("ROK")),
                        "Seoul",
                        "South Korea"
                ),
                new OverseaFlight(
                        4,
                        "Ho Chi Minh City",
                        "Vietnam",
                        ZonedDateTime.of(2023, 8, 4, 15, 0, 0, 0, ZoneId.of("Asia/Bangkok")),
                        ZonedDateTime.of(2023, 8, 5, 5, 0, 0, 0, ZoneId.of("Japan")),
                        "Tokyo",
                        "Japan"
                )
        );

        List<DomesticFlight> domesticFlightsToHanoi = flights.stream()
                .filter(flight -> flight instanceof DomesticFlight)
                .map(flight -> (DomesticFlight) flight)
                .filter(flight -> flight.getDestinationCity().equals("Hanoi"))
                .filter(flight -> flight.getStartTime().toLocalDate().equals(LocalDate.of(2023, 8, 4)))
                .collect(Collectors.toList());

        System.out.println("\nCác chuyến bay nội địa tới Hà Nội ngày 04/08/2023\n");
        for (Flight flight : domesticFlightsToHanoi) {
            System.out.println(flight + "\n");
        }

        List<OverseaFlight> overseaFlightsFromHanoi = flights.stream()
                .filter(flight -> flight instanceof OverseaFlight)
                .map(flight -> (OverseaFlight) flight)
                .filter(flight -> flight.getDepartureCity().equals("Hanoi"))
                .filter(flight -> flight.getStartTime().toLocalDate().equals(LocalDate.of(2023, 8, 4)))
                .collect(Collectors.toList());

        System.out.println("\nCác chuyến bay quốc tế xuất phát từ Hà Nội ngày 04/08/2023\n");
        for (Flight flight : overseaFlightsFromHanoi) {
            System.out.println(flight + "\n");
        }
    }
}