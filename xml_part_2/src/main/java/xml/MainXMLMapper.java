package xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class MainXMLMapper {
    public static void main(String[] args) throws IOException {
        File file = new File("class1.xml");
        XmlMapper mapper = new XmlMapper();
        School school = mapper.readValue(file, School.class);
        for (Student student : school.getStudents()) {
            System.out.println(student);
        }
    }
}
