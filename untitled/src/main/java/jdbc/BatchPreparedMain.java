package jdbc;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class BatchPreparedMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );
        connection.setAutoCommit(false);
        long start = System.currentTimeMillis();

        PreparedStatement statement = connection.prepareStatement(
                "insert into nam (name, dob) values (?, ?)");

        for (int i = 0; i < 10; i++) {
            statement.setString(1, "Vu Hoang Nam " + i);
            statement.setDate(2, new Date(99, 5, 30));
            statement.addBatch();
        }

        int[] count = statement.executeBatch();

        for (int i : count) {
            System.out.println(i);
        }


        connection.commit();

        statement.close();
        connection.close();
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
