package jdbc;
import java.sql.*;

public class TransactionMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://4.194.217.58:5432/t2301e", "t2301e", "t2301e");
        connection.setAutoCommit(false);
        long start = System.currentTimeMillis();

        Statement statement = connection.createStatement();
//        statement.executeUpdate("INSERT INTO employees (name, salary) VALUES ('khoi234', 234)");

//        Savepoint savepoint1 = connection.setSavepoint("Savepoint1");
        try {
            statement.executeUpdate("INSERT INTO employees (name, salary) VALUES ('khoi2345', 2345)");
            statement.executeUpdate("INSERT INTO employees (id, name, salary) VALUES (56, 'khoi2345', 2345)");
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        } finally {

        }


        statement.close();
        connection.close();

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
