package jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
//        List<Student> students = Student.readStudents("Student.csv");
//        DataAccess.insertStudents(students);
//        List<School> schools = School.readSchools("School.csv");
//        DataAccess.insertSchools(schools);
        List<Student> studentUpdate = Student.readStudents("Student update.csv");
        DataAccess.updateStudents(studentUpdate);
    }
}
