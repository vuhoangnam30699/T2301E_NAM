package pom;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import pom.Project;

import java.io.File;
import java.io.IOException;

public class MainPOM {
    public static void main(String[] args) throws IOException {
        File file = new File("pom.xml");
        XmlMapper mapper = new XmlMapper();
        Project projects = mapper.readValue(file, Project.class);
        System.out.println(projects);
    }
}
