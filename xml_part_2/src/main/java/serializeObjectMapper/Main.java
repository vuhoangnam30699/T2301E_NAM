package serializeObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Student student = new Student("Nam", "Vu", LocalDate.of(1999, 6, 30), Gender.MALE);
        String json = objectMapper.writeValueAsString(student);
        System.out.println(json);
    }
}
