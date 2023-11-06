package deserializeObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String jsonString =
                """
                        {
                          "students": [
                            {
                              "id":1,
                              "name":"Tho",
                              "dob":"01-01-1990",
                              "gender": "MALE"
                            },
                            {
                              "id":2,
                              "name":"Son",
                              "dob":"01-01-2001",
                              "gender": "FEMALE"
                            },
                            {
                              "id":3,
                              "name":"An",
                              "dob":"01-01-2002"
                            },
                            {
                              "id":4,
                              "name":"Binh",
                              "dob":"01-01-2001"
                            },
                            {
                              "id":5,
                              "name":"Dat",
                              "dob":"01-01-2004"
                            },
                            {
                              "id":6,
                              "name":"Huy",
                              "dob":null
                            },
                            {
                              "id":7,
                              "name":null,
                              "dob":"01-01-2010"
                            },
                            {
                              "id":null,
                              "name":"NAM",
                              "dob":"30-06-1999"
                            }
                          ]
                        } 
                                                        
                """;

        try {
            Students students = objectMapper.readValue(jsonString, Students.class);
            for (Student student : students.getStudents()) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
