package scenarios;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.Student;

import java.util.Arrays;
import java.util.List;

public class DeserializationTestCase {

    @Test(priority = 1)
    public void deserializeDemo() {

        // Deserialization - Conversion of JSON into POJO Object
        String studentJson = "{\n" +
                "  \"name\" : \"Adam\",\n" +
                "  \"location\" : \"Richmond\",\n" +
                "  \"phone\" : \"313-456-7890\",\n" +
                "  \"courses\" : [ \"Accounts\", \"Commerce\", \"Computer Science\" ]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Student student = objectMapper.readValue(studentJson, Student.class);
            System.out.println("Student Name     : "+student.getName());
            System.out.println("Student Location : "+student.getLocation());
            System.out.println("Student Phone    : "+student.getPhone());
            List<String> courses = Arrays.asList(student.getCourses());
            System.out.println("Student Courses  : "+courses);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
