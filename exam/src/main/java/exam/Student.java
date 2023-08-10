package exam;

import java.time.LocalDate;
import java.util.HashMap;

public class Student {
    private String name;
    private LocalDate dob;
    private String gender;
    private HashMap<Subject,Double> scores = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Student(String name, LocalDate dob, String gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }


    public HashMap<Subject, Double> getScores() {
        return scores;
    }

    public void setScore(HashMap<Subject, Double> scores) {
        this.scores = scores;
    }

    public Student(String name, LocalDate dob, String gender, HashMap<Subject, Double> scores) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.scores = scores;
    }

    @Override
    public String toString() {
        return  "Họ và tên: " + name +
                ", Ngày sinh: " + dob +
                ", Giới tính: " + gender +
                "\nToán:        " + scores.get(Subject.MATHS) +
                "\nVật Lý:      " + scores.get(Subject.PHYSICS) +
                "\nĐịa Lý:      " + scores.get(Subject.GEOGRAPHY) +
                "\nLịch Sử:     " + scores.get(Subject.HISTORY) +
                "\nSinh học:    " + scores.get(Subject.BIOLOGY);
    }
}
