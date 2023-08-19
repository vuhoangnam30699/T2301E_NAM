import java.time.LocalDate;

public class Student extends Record<Integer> {
    private String name;
    private LocalDate dob;

    public Student(Integer id, String name, LocalDate dob) {
        super(id);
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

}