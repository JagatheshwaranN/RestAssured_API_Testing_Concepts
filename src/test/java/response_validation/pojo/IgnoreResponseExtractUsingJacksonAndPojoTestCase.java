package response_validation.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.Employee1;

/**
 * @restapi
 * @get
 */
public class IgnoreResponseExtractUsingJacksonAndPojoTestCase {

    @Test(priority = 1)
    public void ignoreResponseExtractUsingJacksonAndPojo() throws JsonProcessingException {

        String response = """
                {
                    "id": 1,
                    "name": "John Doe",
                    "location": "New York",
                    "phone": "123-456-7890",
                    "landmark": "23rd Jefferson st",
                    "address": "New York"
                }""";

        /*
            To fix this issue - com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException:
            The @JsonIgnoreProperties(ignoreUnknown = true) annotation is added to the Pojo class.
        */
        ObjectMapper objectMapper = new ObjectMapper();
        Employee1 emp1 = objectMapper.readValue(response, Employee1.class);
        System.out.println(emp1.getId());
        System.out.println(emp1.getName());
        System.out.println(emp1.getLocation());
        System.out.println(emp1.getPhone());
        System.out.println(emp1.getAddress());
    }

}
