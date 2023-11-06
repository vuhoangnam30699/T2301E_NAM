package exam;

import java.time.LocalDate;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        School school = new School("FPT Aptech", "8 Ton That Thuyet");
        MathsClass mathsClass = new MathsClass("6A", 6);
        school.addClass(mathsClass);

        Student student1 = new Student("Nguyen Binh", LocalDate.of(2012, 2, 1), "Male");
        HashMap<Subject, Double> scores1 = new HashMap<>();
        scores1.put(Subject.MATHS, 9.3);
        scores1.put(Subject.PHYSICS, 8.1);
        scores1.put(Subject.GEOGRAPHY, 7.4);
        scores1.put(Subject.HISTORY, 8.2);
        scores1.put(Subject.BIOLOGY, 6.5);
        student1.setScore(scores1);
        mathsClass.addStudents(student1);

        Student student2 = new Student("Vu Chien", LocalDate.of(2012, 6, 5), "Male");
        HashMap<Subject, Double> scores2 = new HashMap<>();
        scores2.put(Subject.MATHS, 8.3);
        scores2.put(Subject.PHYSICS, 7.1);
        scores2.put(Subject.GEOGRAPHY, 9.4);
        scores2.put(Subject.HISTORY, 9.1);
        scores2.put(Subject.BIOLOGY, 9.6);
        student2.setScore(scores2);
        mathsClass.addStudents(student2);

        Student student3 = new Student("Tran Dung", LocalDate.of(2012, 3, 4), "Female");
        HashMap<Subject, Double> scores3 = new HashMap<>();
        scores3.put(Subject.MATHS, 9.8);
        scores3.put(Subject.PHYSICS, 7.2);
        scores3.put(Subject.GEOGRAPHY, 9.1);
        scores3.put(Subject.HISTORY, 7.2);
        scores3.put(Subject.BIOLOGY, 7.5);
        student3.setScore(scores3);
        mathsClass.addStudents(student3);

        Student student4 = new Student("Hoang Dat", LocalDate.of(2012, 9, 2), "Male");
        HashMap<Subject, Double> scores4 = new HashMap<>();
        scores4.put(Subject.MATHS, 9.1);
        scores4.put(Subject.PHYSICS, 9.0);
        scores4.put(Subject.GEOGRAPHY, 6.4);
        scores4.put(Subject.HISTORY, 6.8);
        scores4.put(Subject.BIOLOGY, 7.9);
        student4.setScore(scores4);
        mathsClass.addStudents(student4);

        Student student5 = new Student("Dang Trang", LocalDate.of(2012,12 ,11), "Female");
        HashMap<Subject, Double> scores5 = new HashMap<>();
        scores5.put(Subject.MATHS, 6.3);
        scores5.put(Subject.PHYSICS, 9.5);
        scores5.put(Subject.GEOGRAPHY, 8.0);
        scores5.put(Subject.HISTORY, 8.2);
        scores5.put(Subject.BIOLOGY, 8.3);
        student5.setScore(scores5);
        mathsClass.addStudents(student5);


        System.out.println("\n" + school);
        for (Student student: mathsClass.getStudents()) {
            System.out.println("\n" + student);
        }
        System.out.println("\nĐiểm trung bình của lớp " + mathsClass.getName() + ": " + mathsClass.averageScore());

    }
}