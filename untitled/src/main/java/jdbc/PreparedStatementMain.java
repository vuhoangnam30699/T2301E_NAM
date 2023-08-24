package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );

//        PreparedStatement statement = connection.prepareStatement("select * from employees where id = ?");
//        statement.setInt(1, 1);
        PreparedStatement statement = connection.prepareStatement("select * from employees where name ILIKE '%' || ? || '%'");
        statement.setString(1, "O");

        ResultSet resultSet = statement.executeQuery();

        List<Employee> employees = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString(2);
            double salary = resultSet.getDouble("salary");
            employees.add(new Employee(id, name, salary));
        }

        System.out.println(employees);

        statement.close();
        connection.close();
    }
}
