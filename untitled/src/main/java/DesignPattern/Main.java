package DesignPattern;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        insertStudents();
        insertSchools();
    }

    private static void insertStudents() throws SQLException, ClassNotFoundException {
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO students_nam...");
    }

    private static void insertSchools() throws SQLException, ClassNotFoundException {
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO schools_nam...");
    }


}
