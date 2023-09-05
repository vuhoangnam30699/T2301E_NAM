package jdbc1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private Integer id;
    private String name;
    private String code;
    private String address;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public School(Integer id, String name, String code, String address) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
    }

    @Override
    public String toString() {
        return  "\nId:              " + id +
                "\nName:            " + name +
                "\nCode:            " + code +
                "\nAddress:         " + address +
                "\nCreated At:      " + createdAt +
                "\nUpdated At:      " + updatedAt +
                "\n";
    }

    public static List<School> readSchools(String fileName) throws IOException {
        List<School> schools = new ArrayList<>();
        String[] HEADERS = {"#", "Name", "Code", "Address",};
        Reader in = new FileReader(fileName);

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .setSkipHeaderRecord(true)
                .build();

        Iterable<CSVRecord> records = csvFormat.parse(in);

        for (CSVRecord record : records) {
            Integer id = Integer.valueOf(record.get("#"));
            String name = record.get("Name");
            String code = record.get("Code");
            String address = record.get("Address");
            schools.add(new School(id, name, code, address));
        }

        return schools;
    }
}
