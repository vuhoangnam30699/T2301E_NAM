package exam;

import java.util.ArrayList;

public abstract class TClass {
    private String name;
    private Integer grade;
    private ArrayList<Student> students = new ArrayList<Student>();

    public TClass(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void addStudents(Student newStudents) {
        students.add(newStudents);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public abstract Double averageScore();

    @Override
    public String toString() {
        return  "Lớp: " + name;
    }
}

