package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection(
                        "jdbc:postgresql://4.194.217.58:5432/t2301e",
                        "t2301e",
                        "t2301e"
                );

        Statement statement = connection.createStatement();

        String sql =
                "create table public.schools_nam\n" +
                        "(\n" +
                        "    id         serial\n" +
                        "        constraint schools_nam_pk\n" +
                        "            primary key,\n" +
                        "    name       varchar not null,\n" +
                        "    code       varchar not null\n" +
                        "        constraint schools_nam_pk2\n" +
                        "            unique,\n" +
                        "    address    varchar not null,\n" +
                        "    created_at timestamp default current_timestamp,\n" +
                        "    updated_at timestamp default current_timestamp\n" +
                        ");\n" +
                        "\n" +
                        "create table public.students_nam\n" +
                        "(\n" +
                        "    id          serial\n" +
                        "        constraint students_nam_pk2\n" +
                        "            primary key,\n" +
                        "    first_name  varchar not null,\n" +
                        "    last_name   varchar not null,\n" +
                        "    code        varchar not null\n" +
                        "        constraint students_nam_pk\n" +
                        "            unique,\n" +
                        "    gender      varchar not null,\n" +
                        "    school_code varchar not null,\n" +
                        "    dob         date    not null,\n" +
                        "    created_at  timestamp default current_timestamp,\n" +
                        "    updated_at  timestamp default current_timestamp\n" +
                        ");";


        statement.executeUpdate(sql);


        statement.close();
        connection.close();

    }
}