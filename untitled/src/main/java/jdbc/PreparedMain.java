package jdbc;

import java.sql.*;
import java.time.LocalDate;

public class PreparedMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection(
                        "jdbc:postgresql://4.194.217.58:5432/t2301e",
                        "t2301e",
                        "t2301e"
                );

//        Statement statement = connection.createStatement();
//        statement.executeUpdate();

//        "insert into khoivn (name, dob) values ('khoi', '2023-08-08')"

        PreparedStatement statement = connection.prepareStatement(
                "insert into nam (name, dob) values (?, ?)"
        );
        statement.setString(1, "Vu Hoang Nam");
        statement.setDate(2, new Date(1692798942));

        statement.executeUpdate();

        statement.close();
        connection.close();

    }
}
