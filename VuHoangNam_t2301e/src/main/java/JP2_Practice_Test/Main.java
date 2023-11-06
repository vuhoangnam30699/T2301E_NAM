package JP2_Practice_Test;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static User readRow(org.apache.commons.csv.CSVRecord record) throws WarningException {
        Integer id = Integer.valueOf(record.get("id"));
        String firstName = record.get("first_name");
        String lastName = record.get("last_name");
        String job = record.get("job");
        String country = record.get("country");
        String city = record.get("city");
        String streetAddress = record.get("street_address");
        String postalCode = record.get("postal_code");

        if(firstName.isEmpty()) {
            throw new WarningException(new DataWarning(id, "first_name"));
        }
        if(lastName.isEmpty()) {
            throw new WarningException(new DataWarning(id, "last_name"));
        }
        if(job.isEmpty()) {
            throw new WarningException(new DataWarning(id, "job"));
        }
        if(country.isEmpty()) {
            throw new WarningException(new DataWarning(id, "country"));
        }
        if(city.isEmpty()) {
            throw new WarningException(new DataWarning(id, "city"));
        }
        if(streetAddress.isEmpty()) {
            throw new WarningException(new DataWarning(id, "street_address"));
        }
        if(postalCode.isEmpty()) {
            throw new WarningException(new DataWarning(id, "postal_code"));
        }

        User user = new User(id, firstName, lastName, job, country, city, streetAddress, postalCode);
        return user;
    }

    public static List<User> readCSV(String filePath) {
        List<User> userList = new ArrayList<>();
        List<DataWarning> warnings = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(filePath);
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            for (CSVRecord record : csvParser) {
                try {
                    User user = readRow(record);
                    userList.add(user);
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
        return userList;
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
                "INSERT INTO users_namvh (id, first_name, last_name, job, country, city, street_address, postal_code)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
        );
        connection.setAutoCommit(false);

        for (User u : users) {
            statement.setInt(1, u.getId());
            statement.setString(2, u.getFirstName());
            statement.setString(3, u.getLastName());
            statement.setString(4, u.getJob());
            statement.setString(5, u.getCountry());
            statement.setString(6, u.getCity());
            statement.setString(7, u.getFirstName());
            statement.setString(8, u.getPostalCode());
            statement.addBatch();
        }
        statement.executeBatch();
        connection.commit();

        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            String filePath = "User.csv";
            List<User> users = readCSV(filePath);
            insertUsers(users);
            System.out.println("Total number of users inserted: " + users.size());
    }
}