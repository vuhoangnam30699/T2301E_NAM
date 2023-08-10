package stream;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", 18, "HUST"),
                new Student("Bob", 19, "UET"),
                new Student("Calvin", 20, "PTIT"),
                new Student("Derek", 21, "KMA"),
                new Student("Emma", 22, "HUCE"),
                new Student("Frank", 23, "UTC"),
                new Student("Gerrard", 24, "FPT")
        );

        List<String> names = students.stream()
                .map(s -> s.getName())
                .collect(Collectors.toList());

        System.out.println(names);


        List<String> studentsOlderThan12 = students.stream()
                .filter(s -> s.getAge() >= 12)
                .map(s -> s.getName())
                .collect(Collectors.toList());

        System.out.println(studentsOlderThan12);



//        Find the oldest student

        Optional<Student> oldestStudent = students.stream()
                .max(Comparator.comparingInt(s -> s.getAge()));

        System.out.println(oldestStudent);



        OptionalInt maxOptional = students.stream()
                .mapToInt(s -> s.getAge())
                .max();

        int maxAge = maxOptional.orElse(-1);
        System.out.println(maxAge);


//     Tìm student theo tuổi


        Map<Integer, List<String>> studentByAge = students.stream()
                .collect(Collectors.groupingBy(s -> s.getAge(), Collectors.mapping(s -> s.getName(), Collectors.toList())));

        studentByAge.forEach((age, name) -> {
            System.out.println("Age : " + age);
            System.out.println("Name : " + name);
        });



//      Tổng số tuổi

        int sum = students.stream()
                .mapToInt(s -> s.getAge())
                .sum();

        System.out.println("Total age : " + sum);


//      Tìm 1 student có tuổi bằng 19

        Optional<Student> studentAge19 = students.parallelStream()
                .filter(s -> s.getAge() == 19)
                .findAny();

        System.out.println(studentAge19);


//        Kiểm tra tất cả student có phải 18 tuổi không

        boolean allStudentsAre18 = students.stream()
                .allMatch(s -> s.getAge() == 18);

        System.out.println(allStudentsAre18);


//        Kiểm tra tất cả

        List<Boolean> studentWho20YearsOld = students.stream()
                .map(s -> s.getAge() == 20)
                .collect(Collectors.toList());

        System.out.println(studentWho20YearsOld);


//        Sắp xếp tên theo thứ thự A - Z

        List<Student> sortStudentByName = students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println(sortStudentByName);

    }
}