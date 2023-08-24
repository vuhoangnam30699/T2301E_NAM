package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ExecuteUpdateMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );

        Statement statement = connection.createStatement();

        String sql = "create table public.nam\n" +
                "(\n" +
                "    id   serial\n" +
                "        constraint nam_pk\n" +
                "            primary key,\n" +
                "    name varchar not null,\n" +
                "    dob  date    not null\n" +
                ");";

//        String sql = "insert into employees(id, name, salary) values (1, 'khoi', 10000)";
        statement.executeUpdate(sql);

        statement.close();
        connection.close();
    }
}
