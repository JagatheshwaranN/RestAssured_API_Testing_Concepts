package scenarios;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.Student;

public class SerializationTestCase {

    @Test(priority = 1)
    public void serializeDemo(){

        // Serialization - Conversion of POJO object into JSON
        Student student = new Student();
        student.setName("Adam");
        student.setLocation("Richmond");
        student.setPhone("313-456-7890");
        String[] courses = {"Accounts", "Commerce", "Computer Science"};
        student.setCourses(courses);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String studentJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
            System.out.println(studentJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
