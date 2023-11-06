import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String gender;
    private LocalDate dob;

    public Student(String name, String gender, LocalDate dob) throws CommonException {

        List<ValidationError> errors = new ArrayList<>();

        if (!name.matches("[a-zA-Z ]+")) {
            errors.add(new ValidationError(100, "Name " + name + " is not valid"));
        }

        if (dob.isBefore(LocalDate.of(2006, 1, 1)) || dob.isAfter(LocalDate.of(2017, 12, 31))) {
            errors.add(new ValidationError(200, "Year " + dob.getYear() + " is not valid"));
        }

        if(!errors.isEmpty()) {
            throw new CommonException(errors);
        }

        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }

}
