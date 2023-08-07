package Part2;

import Part1.DomesticFlight;
import Part1.Flight;
import Part1.OverseaFlight;

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
                        ZonedDateTime.of(2023, 8, 5, 8, 0, 0, 0, ZoneId.of("Asia/Ho_Chi_Minh")),
                        ZonedDateTime.of(2023, 8, 5, 10, 0, 0, 0, ZoneId.of("Asia/Ho_Chi_Minh")),
                        "Ho Chi Minh City"
                ),
                new OverseaFlight(
                        2,
                        "Hanoi",
                        "Vietnam",
                        ZonedDateTime.of(2023, 8, 4, 14, 0, 0, 0, ZoneId.of("Asia/Ho_Chi_Minh")),
                        ZonedDateTime.of(2023, 8, 5, 4, 0, 0, 0, ZoneId.of("Asia/Shanghai")),
                        "Shanghai",
                        "China"
                ),
                new OverseaFlight(
                        3,
                        "Hanoi",
                        "Vietnam",
                        ZonedDateTime.of(2023, 8, 4, 15, 0, 0, 0, ZoneId.of("Asia/Ho_Chi_Minh")),
                        ZonedDateTime.of(2023, 8, 6, 18, 0, 0, 0, ZoneId.of("America/New_York")),
                        "New York City",
                        "USA"
                ),
                new OverseaFlight(
                        4,
                        "Hanoi",
                        "Vietnam",
                        ZonedDateTime.of(2023, 8, 4, 15, 0, 0, 0, ZoneId.of("Asia/Ho_Chi_Minh")),
                        ZonedDateTime.of(2023, 8, 6, 6, 0, 0, 0, ZoneId.of("Europe/London")),
                        "London",
                        "United Kingdom"
                ),
                new OverseaFlight(
                        5,
                        "Hanoi",
                        "Vietnam",
                        ZonedDateTime.of(2023, 8, 4, 15, 0, 0, 0, ZoneId.of("Asia/Ho_Chi_Minh")),
                        ZonedDateTime.of(2023, 8, 6, 6, 0, 0, 0, ZoneId.of("America/Sao_Paulo")),
                        "Rio de Janeiro",
                        "Brazil"
                )
        );

        List<Location> locations = List.of(
                new Location(
                        "Hanoi",
                        "Vietnam",
                        Continent.ASIA,
                        21.028333,
                        105.854167
                ),
                new Location(
                        "Ho Chi Minh City",
                        "Vietnam",
                        Continent.ASIA,
                        10.775556,
                        106.701944
                ),
                new Location(
                        "Shanghai",
                        "China",
                        Continent.ASIA,
                        31.228611,
                        121.474722
                ),
                new Location(
                        "New York City",
                        "USA",
                        Continent.NORTH_AMERICA,
                        40.712778,
                        -74.006111
                ),
                new Location(
                        "London",
                        "United Kingdom",
                        Continent.EUROPE,
                        51.507222,
                        -0.1275
                ),
                new Location(
                        "Rio de Janeiro",
                        "Brazil",
                        Continent.SOUTH_AMERICA,
                        -22.911111,
                        -43.205556
                )
        );

//        for (Flight flight : flights) {
//            System.out.println("\n" + flight);
//        }

        Flight flightA = new OverseaFlight(
                5,
                "Hanoi",
                "Vietnam",
                ZonedDateTime.of(2023, 8, 4, 15, 0, 0, 0, ZoneId.of("Asia/Ho_Chi_Minh")),
                ZonedDateTime.of(2023, 8, 6, 6, 0, 0, 0, ZoneId.of("America/Sao_Paulo")),
                "Rio de Janeiro",
                "Brazil"
        );

        System.out.println(flightA.calculatePrice());

    }
}
