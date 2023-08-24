package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchFailedMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e", "t2301e");
        connection.setAutoCommit(false);
        long start = System.currentTimeMillis();

        Statement statement = connection.createStatement();
        statement.addBatch("insert into employees (id, name, salary) values (57, 'khoi123', 123)");
        statement.addBatch("insert into test (id) values (10)");


        try {
            int[] count = statement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.executeBatch();
            connection.commit();
        }


        statement.close();
        connection.close();

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
