package jdbc;

import java.sql.*;

import java.util.List;

public class DataAccess {

    public static void insertStudents(List<Student> students) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection(
                        "jdbc:postgresql://4.194.217.58:5432/t2301e",
                        "t2301e",
                        "t2301e"
                );

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO students_nam (id, first_name, last_name, code, gender, school_code, dob, created_at, updated_at)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), NULL)");
        connection.setAutoCommit(false);

        for (Student student : students) {
            statement.setInt(1, student.getId());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
            statement.setString(4, student.getCode());
            statement.setString(5, student.getGender());
            statement.setString(6, student.getSchoolCode());
            statement.setDate(7, Date.valueOf(student.getDob()));
            statement.addBatch();
        }
        statement.executeBatch();
        connection.commit();


        statement.close();
        connection.close();

    }

    public static void insertSchools(List<School> schools) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection(
                        "jdbc:postgresql://4.194.217.58:5432/t2301e",
                        "t2301e",
                        "t2301e"
                );

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO schools_nam (id, name, code, address, created_at, updated_at)" +
                        "VALUES (?, ?, ?, ?, NOW(), NULL)");
        connection.setAutoCommit(false);

        for (School school : schools) {
            statement.setInt(1, school.getId());
            statement.setString(2, school.getName());
            statement.setString(3, school.getCode());
            statement.setString(4, school.getAddress());
            statement.addBatch();
        }
        statement.executeBatch();
        connection.commit();


        statement.close();
        connection.close();

    }

    public static void updateStudents(List<Student> students) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection(
                        "jdbc:postgresql://4.194.217.58:5432/t2301e",
                        "t2301e",
                        "t2301e"
                );
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE students_nam " +
                        "SET first_name = ?," +
                        "last_name = ?," +
                        "gender = ?," +
                        "school_code = ?," +
                        "dob = ?," +
                        "updated_at = NOW() " +
                        "WHERE code = ? "
        );
        connection.setAutoCommit(false);

        for (Student student : students) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getGender());
            statement.setString(4, student.getSchoolCode());
            statement.setDate(5, Date.valueOf(student.getDob()));
            statement.setString(6, student.getCode());
            statement.addBatch();
        }
        statement.executeBatch();
        connection.commit();

        statement.close();
        connection.close();
    }
}
