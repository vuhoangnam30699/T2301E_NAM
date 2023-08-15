import java.time.LocalDate;

public class InvalidDobException extends CommonException {
    public InvalidDobException(LocalDate dob) {
        super(200, "Year of birth " + dob.getYear() + " is not valid");
    }
}
