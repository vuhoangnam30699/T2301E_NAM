import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database<Student> database = new Database<>();

        Student student1 = new Student(
                1,
                ZonedDateTime.of(2023, 8, 16, 12, 0, 0, 0, ZoneId.of("Asia/Bangkok")),
                ZonedDateTime.of(2023, 8, 16, 13, 0, 0, 0, ZoneId.of("Asia/Bangkok")),
                "Bill Gates",
                LocalDate.of(1955, 10, 28));

        Student student2 = new Student(
                2,
                ZonedDateTime.of(2023, 8, 16, 14, 0, 0, 0, ZoneId.of("Asia/Bangkok")),
                ZonedDateTime.of(2023, 8, 16, 15, 0, 0, 0, ZoneId.of("Asia/Bangkok")),
                "Steve Jobs",
                LocalDate.of(1955, 2, 24));

        Student student3 = new Student(
                3,
                ZonedDateTime.of(2023, 8, 16, 16, 0, 0, 0, ZoneId.of("Asia/Bangkok")),
                ZonedDateTime.of(2023, 8, 16, 17, 0, 0, 0, ZoneId.of("Asia/Bangkok")),
                "Jeff Bezos",
                LocalDate.of(1964, 1, 12));

        Student student4 = new Student(
                4,
                ZonedDateTime.of(2023, 8, 16, 18, 0, 0, 0, ZoneId.of("Asia/Bangkok")),
                ZonedDateTime.of(2023, 8, 16, 19, 0, 0, 0, ZoneId.of("Asia/Bangkok")),
                "Mark Zuckerberg",
                LocalDate.of(1984, 5, 14));

        Student student5 = new Student(
                5,
                ZonedDateTime.of(2023, 8, 16, 20, 0, 0, 0, ZoneId.of("Asia/Bangkok")),
                ZonedDateTime.of(2023, 8, 16, 21, 0, 0, 0, ZoneId.of("Asia/Bangkok")),
                "Elon Musk",
                LocalDate.of(1971, 6, 28));

        List<Student> students = List.of(student1, student2, student3, student4, student5);
        for(Student student : students){
            database.save(student);
        }

        System.out.println("\nFind id 1:\n" + database.find(1));
        System.out.println("\nDelete id 2:\n" + database.delete(2));

        System.out.println("\nFind by created at after 14:00:00T2023-08-16:\n" + database.findByCreatedAtAfter(ZonedDateTime.of(2023, 8, 16, 14, 0, 0, 0, ZoneId.of("Asia/Bangkok"))));
        System.out.println("\nFind by update at after 19:00:00T2023-08-16:\n" + database.findByUpdatedAtAfter(ZonedDateTime.of(2023, 8, 16, 19, 0, 0, 0, ZoneId.of("Asia/Bangkok"))));
    }
}