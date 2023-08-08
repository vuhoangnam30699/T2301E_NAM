package Part2;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OverseaFlight extends Flight {
    private String destinationCity;
    private String destinationCountry;
    private String destinationContinent;
    private Double distance;

    public Double calculatePrice() {
        return (destinationContinent.equals(getDepartureContinent()) ? 1490 : 1780) * distance;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDestination:     " + destinationCity + ", " + destinationCountry +
                "\nDistance:        " + distance + " km" +
                "\nPrice:           " + calculatePrice() + " vnđ";
    }
}

