package WorkWithJavaFile;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    MALE("Nam", 1), FEMALE("Nu", 2);
    private final String value;
    private final Integer number;

    public static Gender convert(String value) {
        if (MALE.getValue().equals(value)) {
            return MALE;
        } else if (value.equals(FEMALE.getValue())) {
            return FEMALE;
        }
        return null;
    }
}

