import java.time.LocalDate;

public class Student {
    private String name;
    private String gender;
    private LocalDate dob;

    public Student(String name, String gender, LocalDate dob) throws InvalidNameException, InvalidDobException {
        if (!name.matches("[a-zA-Z ]+")) {
            throw new InvalidNameException(name);
        }

        if (dob.isBefore(LocalDate.of(2006, 1, 1)) || dob.isAfter(LocalDate.of(2017, 12, 31))) {
            throw new InvalidDobException(dob);
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
