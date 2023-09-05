package DesignPattern;

import java.time.LocalDate;
import java.util.List;

public interface StudentDAO {
    List<Student> findAllStudents();

    void insert(List<Student> students);

    List<Student> findStudentsLessThanDob(LocalDate Date);
}
