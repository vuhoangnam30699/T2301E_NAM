package jdbc1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String code;
    private String gender;
    private String schoolCode;
    private LocalDate dob;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public Student(Integer id, String firstName, String lastName, String code, String gender, String schoolCode, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
        this.gender = gender;
        this.schoolCode = schoolCode;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return  "\nId:              " + id +
                "\nName:            " + firstName + " " + lastName +
                "\nCode:            " + code +
                "\nGender:          " + gender +
                "\nSchool Code:     " + schoolCode +
                "\nDoB:             " + dob +
                "\nCreated At:      " + createdAt +
                "\nUpdated At:      " + updatedAt +
                "\n";
    }


    public static List<Student> readStudents(String fileName) throws IOException {
        List<Student> students = new ArrayList<>();
        String[] HEADERS = {"#", "First Name", "Last Name", "Code", "Gender", "School code", "DOB"};
        Reader in = new FileReader(fileName);

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .setSkipHeaderRecord(true)
                .build();

        Iterable<CSVRecord> records = csvFormat.parse(in);

        for (CSVRecord record : records) {
            Integer id = Integer.parseInt(record.get("#"));
            String firstName = record.get("First Name");
            String lastName = record.get("Last Name");
            String code = record.get("Code");
            String gender = record.get("Gender");
            String schoolCode = record.get("School code");
            LocalDate dob = LocalDate.parse(record.get("DOB"));
            students.add(new Student(id, firstName, lastName, code, gender, schoolCode, dob));
        }

        return students;
    }
}
