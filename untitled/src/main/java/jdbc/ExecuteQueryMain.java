package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExecuteQueryMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from nam");

        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Date dob = resultSet.getDate("dob");

            Student student = new Student(id, name, dob);
            students.add(student);
        }

        System.out.println(students);


//        String sql = "select * from employees";
//        ResultSet resultSet = statement.executeQuery(sql);

//        List<Employee> employyes = new ArrayList<>();
//
//        while (resultSet.next()){
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString(2);
//            double salary = resultSet.getDouble("salary");
//            employees.add(new Employee(id, name, salary));
//        }
//
//        System.out.println(employees);

        statement.close();
        connection.close();

    }
}
