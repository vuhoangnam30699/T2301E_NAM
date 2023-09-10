package users;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static User readRow(CSVRecord row) {
        String idString = row.get("id");
        String firstName = row.get("first_name");
        String lastName = row.get("last_name");
        String email = row.get("email");
        String gender = row.get("gender");
        int id = Integer.parseInt(idString);

        if (firstName.isEmpty()) {
            throw new WarningException(new DataWarning(id, "first_name"));
        }

        if (lastName.isEmpty()) {
            throw new WarningException(new DataWarning(id, "last_name"));
        }

        if (email.isEmpty()) {
            throw new WarningException(new DataWarning(id, "email"));
        }

        if (gender.isEmpty()) {
            throw new WarningException(new DataWarning(id, "gender"));
        }


        User user = new User(id, firstName, lastName, email, gender);
        return user;
    }

    public static List<User> readCSV(String filePath) {
        List<User> userlist = new ArrayList<>();
        List<DataWarning> warnings = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            CSVParser csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader());
            for (CSVRecord record : csvParser) {
                try {
                    User user = readRow(record);
                    userlist.add(user);
                } catch (WarningException e) {
                    warnings.add(e.getWarning());
                }
            }
            csvParser.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(warnings);
        return userlist;
    }

    private static void insertUsers(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager
                .getConnection(

                        "jdbc:postgresql://4.194.217.58:5432/t2301e",
                        "t2301e",
                        "t2301e"
                );

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO users_namvh (id,first_name,last_name,email,gender)" +
                        "VALUES (?,?,?,?,?)");
        connection.setAutoCommit(false);

        for (User s : users
        ) {
            statement.setInt(1, s.getId());
            statement.setString(2, s.getFirstName());
            statement.setString(3, s.getLastName());
            statement.setString(4, s.getEmail());
            statement.setString(5, s.getGender());
            statement.addBatch();
        }
        statement.executeBatch();
        connection.commit();

        statement.close();
        connection.close();
    }

    private static void insertOrders(List<Order> orders) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager
                .getConnection(

                        "jdbc:postgresql://4.194.217.58:5432/t2301e",
                        "t2301e",
                        "t2301e"
                );

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO orders_namvh (id,user_id,product,quantity)" +
                        "VALUES (?,?,?,?)");
        connection.setAutoCommit(false);

        for (Order s : orders
        ) {
            statement.setInt(1, s.getId());
            statement.setInt(2, s.getUserId());
            statement.setString(3, s.getProduct());
            statement.setInt(4, s.getQuantity());
            statement.addBatch();
        }
        statement.executeBatch();
        connection.commit();

        statement.close();
        connection.close();
    }

    public static Order readRow2(CSVRecord row) {
        String idString = row.get("id");
        String userIdString = row.get("user id");
        String product = row.get("product");
        String quantityString = row.get("quantity");

        int id = Integer.parseInt(idString);
        int userId = Integer.parseInt(userIdString);
        int quantity = Integer.parseInt(quantityString);


        Order order = new Order(id, userId, product, quantity);
        return order;
    }

    public static List<Order> readFileCsv(String filePath) {
        List<Order> orders = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            for (CSVRecord csvRecord : csvParser) {
                Order order = readRow2(csvRecord);
                orders.add(order);
            }

            fileReader.close();
            csvParser.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public static List<User> getUsers() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager
                .getConnection(

                        "jdbc:postgresql://4.194.217.58:5432/t2301e",
                        "t2301e",
                        "t2301e"
                );
        Statement statement = connection.createStatement();
        List<User> users = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM users_namvh");

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String gender = resultSet.getString("gender");
            users.add(new User(id, firstName, lastName, email, gender));
        }
        statement.close();
        connection.close();


        return users;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String filePath = "orders.csv";
        List<Order> orders = readFileCsv(filePath);
        List<User> users = getUsers();

        List<Integer> userIds = users.stream()
                .map(u -> u.getId()).collect(Collectors.toList());

        System.out.println(userIds);

        List<Order> filteredOrders = orders.stream()
                .filter(o -> userIds.contains(o.getUserId()))
                .collect(Collectors.toList());

        System.out.println(filteredOrders);
        System.out.println(filteredOrders.size());

        insertOrders(filteredOrders);

    }

}
