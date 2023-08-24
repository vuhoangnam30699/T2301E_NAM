package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection(
                        "jdbc:postgresql://4.194.217.58:5432/t2301e",
                        "t2301e",
                        "t2301e"
                );

        long start = System.currentTimeMillis();

        Statement statement = connection.createStatement();
        for (int i = 0; i < 100; i++) {
            statement.executeUpdate(
                    "insert into nam (name, dob) values ('Vu Hoang Nam " + i + "', '1999-06-30')"
            );
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);


        statement.close();
        connection.close();


    }
}
