package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BatchMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e");

        Statement statement = connection.createStatement();

        connection.setAutoCommit(false);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            statement.addBatch(
                    "insert into nam (name, dob) values ('Vu Hoang Nam " + i + "', '1999-06-30')"
            );
            //            statement.executeUpdate("insert into employees (name, salary) values ('khoi1', 1000)");
        }

        int[] count = statement.executeBatch();

        connection.commit();

        statement.close();
        connection.close();

        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }
}
