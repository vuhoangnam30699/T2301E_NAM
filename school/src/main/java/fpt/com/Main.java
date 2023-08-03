package fpt.com;



import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Andy", 19, "NEU"),
                new Student("Bob", 20, "FTU"),
                new Student("Calvin", 21, "AOF"),
                new Student("Derek", 22, "BA"),
                new Student("Eric", 22, "HUST"),
                new Student("Frank", 21, "UET"),
                new Student("Gerald", 20, "PTIT"),
                new Student("Howard", 19, "KMA")
        );

        List<School> schools = List.of(
                new School("NEU", "National Economics University", "Hanoi"),
                new School("FTU", "Foreign Trade University", "Hanoi"),
                new School("AOF", "Academy Of Finance", "Hanoi"),
                new School("BA", "Banking Academy", "Hanoi"),
                new School("HUST", "Hanoi University of Science and Technology", "Hanoi"),
                new School("UET", "VNU University of Engineering and Technology", "Hanoi"),
                new School("PTIT", "Posts and Telecommunications Institute of Technology", "Hanoi"),
                new School("KMA", "Vietnam Academy of Cryptography Techniques", "Hanoi")
        );


        Map<School, List<Student>> groupBySchool = students.stream()
                .collect(Collectors.groupingBy(student -> schools.stream()
                        .filter(school -> school.getSchoolId().equals(student.getSchoolId()))
                        .findFirst()
                        .orElse(null)));

        for (School key : groupBySchool.keySet()) {
            System.out.println("\n");
            System.out.println(key);
            System.out.println(groupBySchool.get(key));
        }
    }
}