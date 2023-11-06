package deserializeDOM;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String jsonString =
                """
                        {
                          "students": [
                            {
                              "id":null,
                              "name":"Tho",
                              "dob":"1990-01-01"
                            },
                            {
                              "id":2,
                              "name":"Son",
                              "dob":"2001-01-01"
                            },
                            {
                              "id":3,
                              "name":"An",
                              "dob":"2002-01-01"
                            },
                            {
                              "id":4,
                              "name":"Binh",
                              "dob":"2001-01-01"
                            },
                            {
                              "id":5,
                              "name":"Dat",
                              "dob":"2004-01-01"
                            },
                            {
                              "id":6,
                              "name":"Huy",
                              "dob":"2006-01-01"
                            },
                            {
                              "id":7,
                              "name":"Dao",
                              "dob":"2010-01-01"
                            },
                            {
                              "id":null,
                              "name":null,
                              "dob":null
                            }
                          ]
                        } 
                                                        
                """;

        List<Student> students = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray studentsArray = jsonObject.getJSONArray("students");
        for (int i = 0; i < studentsArray.length(); i++) {
            JSONObject studentObject = studentsArray.getJSONObject(i);
//            if (studentObject.isNull("id") || studentObject.isNull("name") || studentObject.isNull("dob")) {
//                System.out.println("Null value encountered in JSON data for student at index: " + (i+1));
//                continue;
//            }
            Integer id = studentObject.isNull("id") ? null : studentObject.getInt("id");
            String name = studentObject.isNull("name") ? null : studentObject.getString("name");
            LocalDate dob = studentObject.isNull("dob") ? null : LocalDate.parse(studentObject.getString("dob"));
            Student student = new Student(id, name, dob);
            students.add(student);
        }
        System.out.println(students);
    }
}
