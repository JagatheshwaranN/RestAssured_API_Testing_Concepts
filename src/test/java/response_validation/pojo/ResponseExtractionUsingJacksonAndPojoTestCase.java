package response_validation.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.Employee1;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class ResponseExtractionUsingJacksonAndPojoTestCase {

    @Test(priority = 1)
    public void responseExtractUsingJacksonAndPojo() throws JsonProcessingException {

        String response =
                given()
                .when()
                        .get("http://localhost:3000/employees/1")
                        .asPrettyString();

        ObjectMapper objectMapper = new ObjectMapper();
        Employee1 emp1 = objectMapper.readValue(response, Employee1.class);
        System.out.println(emp1.getId());
        System.out.println(emp1.getName());
        System.out.println(emp1.getLocation());
        System.out.println(emp1.getPhone());
        System.out.println(emp1.getAddress());
    }

}
