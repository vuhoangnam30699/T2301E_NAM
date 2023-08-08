package Part2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Flight {
    private int number;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String departureCity;
    private String departureCountry;
    private String departureContinent;

    public abstract Double calculatePrice();

    @Override
    public String toString() {
        return "Flight number:   " + number +
                "\nStart Time:      " + startTime +
                "\nEnd Time:        " + endTime +
                "\nDeparture:       " + departureCity +
                ", " + departureCountry;
    }
}