import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Database<Student, Integer> students = new Database<>();
        Database<School, Integer> schools = new Database<>();


        LocalDate dobStudent1 = LocalDate.of(1955, 10, 28);
        Student student1 = new Student(null, "Bill Gates", dobStudent1);
        students.save(student1);

        LocalDate dobStudent2 = LocalDate.of(1964, 1, 12);
        Student student2 = new Student(null, "Jeff Bezos", dobStudent2);
        students.save(student2);

        LocalDate dobStudent3 = LocalDate.of(1955, 2, 24);
        Student student3 = new Student(null, "Steve Jobs", dobStudent3);
        students.save(student3);

        LocalDate dobStudent4 = LocalDate.of(1971, 6, 28);
        Student student4 = new Student(null, "Elon Musk", dobStudent4);
        students.save(student4);

        LocalDate dobStudent5 = LocalDate.of(1984, 5, 14);
        Student student5 = new Student(null, "Mark Zuckerberg", dobStudent5);
        students.save(student5);


        School school1 = new School(null, "Harvard University", "Cambridge, Massachusetts");
        schools.save(school1);

        School school2 = new School(null, "Yale University", "New Haven, Connecticut");
        schools.save(school2);

        School school3 = new School(null, "Princeton University", "Princeton, New Jersey");
        schools.save(school3);

        School school4 = new School(null, "Columbia University", "New York City, New York");
        schools.save(school4);

        School school5 = new School(null, "University of Pennsylvania", "Philadelphia, Pennsylvania");
        schools.save(school5);

        School school6 = new School(null, "Dartmouth College", "Hanover, New Hampshire");
        schools.save(school6);

        School school7 = new School(null, "Cornell University", "Ithaca, New York");
        schools.save(school7);

        School school8 = new School(null, "Brown University", "Providence, Rhode Island");
        schools.save(school8);


        System.out.println("Student records:");
        for (Student student : students.getAllRecords()) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", DoB: " + student.getDob() +
                    ", Created At: " + student.getCreatedAt() + ", Updated At: " + student.getUpdatedAt());
        }

        System.out.println("School records:");
        for (School school : schools.getAllRecords()) {
            System.out.println("ID: " + school.getId() + ", Name: " + school.getName() + ", Address: " + school.getAddress() +
                    ", Created At: " + school.getCreatedAt() + ", Updated At: " + school.getUpdatedAt());
        }
    }
}