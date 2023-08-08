package Part2;

import java.time.ZoneId;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Location hanoi = Location.builder()
                .city("Hanoi")
                .country("Vietnam")
                .continent("ASIA")
                .latitude(21.213035)
                .longitude(105.799157)
                .build();

        Location saigon = Location.builder()
                .city("Saigon")
                .country("Vietnam")
                .continent("ASIA")
                .latitude(10.776888)
                .longitude(106.700729)
                .build();

        Location rio = Location.builder()
                .city("Rio de Janeiro")
                .country("Brazil")
                .continent("SOUTH_AMERICA")
                .latitude(-22.911111)
                .longitude(-43.205556)
                .build();

        Location tokyo = Location.builder()
                .city("Tokyo")
                .country("Japan")
                .continent("ASIA")
                .latitude(35.682839)
                .longitude(139.759455)
                .build();

        Location chicago = Location.builder()
                .city("Chicago")
                .country("USA")
                .continent("NORTH_AMERICA")
                .latitude(41.878113)
                .longitude(-87.629799)
                .build();

        Location cairo = Location.builder()
                .city("Cairo")
                .country("Egypt")
                .continent("AFRICA")
                .latitude(30.044444)
                .longitude(31.235833)
                .build();

        Location london = Location.builder()
                .city("London")
                .country("United Kingdom")
                .continent("EUROPE")
                .latitude(51.507222)
                .longitude(-0.1275)
                .build();

        Location melbourne = Location.builder()
                .city("Melbourne")
                .country("Australia")
                .continent("OCEANIA")
                .latitude(-25.0)
                .longitude(133.0)
                .build();


        List<Location> locations = List.of(
                hanoi, saigon, tokyo, chicago, rio, cairo, london, melbourne
        );
        Map<String, Location> locationMap = locations.stream().collect(Collectors.toMap(
                Location::getCity, Function.identity()
        ));


        DomesticFlight flightA = DomesticFlight.builder()
                .number(1)
                .departureCity("Hanoi")
                .departureCountry("Vietnam")
                .startTime(LocalDateTime.of(2023, 8, 5, 8, 0, 0, 0))
                .endTime(LocalDateTime.of(2023, 8, 5, 10, 0, 0, 0))
                .destinationCity("Saigon")
                .distance(DistanceUtils.calculateDistance(locationMap.get("Hanoi"), locationMap.get("Saigon")))
                .build();

        OverseaFlight flightB = OverseaFlight.builder()
                .number(2)
                .departureCity("Hanoi")
                .departureCountry("Vietnam")
                .startTime(LocalDateTime.of(2023, 8, 4, 12, 0, 0, 0))
                .endTime(LocalDateTime.of(2023, 8, 6, 0, 0, 0, 0))
                .destinationCity("Chicago")
                .destinationCountry("USA")
                .destinationContinent("NORTH_AMERICA")
                .distance(DistanceUtils.calculateDistance(locationMap.get("Hanoi"), locationMap.get("Chicago")))
                .build();

        OverseaFlight flightC = OverseaFlight.builder()
                .number(3)
                .departureCity("Hanoi")
                .departureCountry("Vietnam")
                .startTime(LocalDateTime.of(2023, 8, 4, 14, 0, 0, 0))
                .endTime(LocalDateTime.of(2023, 8, 4, 23, 0, 0, 0))
                .destinationCity("Tokyo")
                .destinationCountry("Japan")
                .destinationContinent("ASIA")
                .distance(DistanceUtils.calculateDistance(locationMap.get("Hanoi"), locationMap.get("Tokyo")))
                .build();

        OverseaFlight flightD = OverseaFlight.builder()
                .number(4)
                .departureCity("Hanoi")
                .departureCountry("Vietnam")
                .startTime(LocalDateTime.of(2023, 8, 4, 15, 0, 0, 0))
                .endTime(LocalDateTime.of(2023, 8, 5, 15, 0, 0, 0))
                .destinationCity("London")
                .destinationCountry("United Kingdom")
                .destinationContinent("EUROPE")
                .distance(DistanceUtils.calculateDistance(locationMap.get("Hanoi"), locationMap.get("London")))
                .build();

        OverseaFlight flightE = OverseaFlight.builder()
                .number(5)
                .departureCity("Hanoi")
                .departureCountry("Vietnam")
                .startTime(LocalDateTime.of(2023, 8, 4, 15, 0, 0, 0))
                .endTime(LocalDateTime.of(2023, 8, 6, 15, 0, 0, 0))
                .destinationCity("Rio de Janeiro")
                .destinationCountry("Brazil")
                .destinationContinent("SOUTH_AMERICA")
                .distance(DistanceUtils.calculateDistance(locationMap.get("Hanoi"), locationMap.get("Rio de Janeiro")))
                .build();

        OverseaFlight flightF = OverseaFlight.builder()
                .number(6)
                .departureCity("Hanoi")
                .departureCountry("Vietnam")
                .startTime(LocalDateTime.of(2023, 8, 4, 10, 0, 0, 0))
                .endTime(LocalDateTime.of(2023, 8, 5, 6, 0, 0, 0))
                .destinationCity("Cairo")
                .destinationCountry("Egypt")
                .destinationContinent("AFRICA")
                .distance(DistanceUtils.calculateDistance(locationMap.get("Hanoi"), locationMap.get("Cairo")))
                .build();

        OverseaFlight flightG = OverseaFlight.builder()
                .number(7)
                .departureCity("Hanoi")
                .departureCountry("Vietnam")
                .startTime(LocalDateTime.of(2023, 8, 4, 9, 0, 0, 0))
                .endTime(LocalDateTime.of(2023, 8, 5, 8, 0, 0, 0))
                .destinationCity("Melbourne")
                .destinationCountry("Australia")
                .destinationContinent("OCEANIA")
                .distance(DistanceUtils.calculateDistance(locationMap.get("Hanoi"), locationMap.get("Melbourne")))
                .build();

        List<Flight> flights = List.of(flightA, flightB, flightC, flightD, flightE, flightF, flightG);
        flights.forEach(f -> {
            System.out.println(f);
            System.out.println("\n");
        });
    }
}
