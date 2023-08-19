package WorkWithJavaFile;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class ReadFile {
    public static void main(String[] args) throws IOException {
        Reader in = new FileReader("C:\\Users\\Admin\\IdeaProjects\\untitled\\src\\main\\java\\example\\student.csv");
        String[] HEADERS = {"Number", "Name", "Age", "Gender"};

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .setSkipHeaderRecord(true)
                .build();

        Iterable<CSVRecord> records = csvFormat.parse(in);
        List<Student> students = new ArrayList<>();
        for (CSVRecord record : records) {
            Integer number = Integer.parseInt(record.get("Number"));
            String name = record.get("Name");
            Integer age = Integer.parseInt(record.get("Age"));
            Gender gender = Gender.convert(record.get("Gender"));

            Student student = Student.builder()
                    .number(number)
                    .name(name)
                    .age(age)
                    .gender(gender)
                    .build();

            students.add(student);
        }

        System.out.println(students);

    }

    public static Object test() {
        return null;
    }
}