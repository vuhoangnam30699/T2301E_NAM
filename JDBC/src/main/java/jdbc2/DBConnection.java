package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    private static final String url = "jdbc:postgresql://4.194.217.58:5432/t2301e";
    private static final String user = "t2301e";
    private static final String password = "t2301e";
    private static final String driver = "org.postgresql.Driver";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

}
