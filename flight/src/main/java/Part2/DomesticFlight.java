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
public class DomesticFlight extends Flight {
    private String destinationCity;
    private Double distance;

    @Override
    public Double calculatePrice() {
        return 1120 * distance;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDestination:     " + destinationCity +
                ", Vietnam" +
                "\nDistance:        " + distance + " km" +
                "\nPrice:           " + calculatePrice() + " vnđ";
    }
}

