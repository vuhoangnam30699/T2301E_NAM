import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    private static final ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(String name, String gender, LocalDate dob) {
        try {
            Student student = new Student(name, gender, dob);
            students.add(student);
        } catch (CommonException e) {
//            System.out.println(e.getMessage());
            e.getErrors().forEach(error -> System.out.println(
                    String.format("Error: %s, more info: \"%s\"", error.getErrorCode(), error.getExtraInfo())
            ));
        }
    }

    public static void main(String[] args) {
        addStudent("Ron Weasley", "Male", LocalDate.of(2005, 12, 31));
        addStudent("Harry Potter", "Male", LocalDate.of(2017, 12, 31));
        addStudent("Khoi @123", "Male", LocalDate.of(2005, 1, 1));
        addStudent("Hermione Granger", "Female", LocalDate.of(2018, 1, 1));

        for (Student student : students) {
            System.out.println(student.getName() + ", " + student.getGender() + ", " + student.getDob());
        }
    }
}