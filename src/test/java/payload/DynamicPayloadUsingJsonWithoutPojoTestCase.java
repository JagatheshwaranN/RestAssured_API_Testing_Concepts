package payload;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @post
 */
public class DynamicPayloadUsingJsonWithoutPojoTestCase {

    @Test(priority = 1)
    public void postUsingJsonWithoutPojoByJacksonAsDynamicPayload() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> address = objectMapper.readValue(new File("src//test//resources//address.json"), new TypeReference<Map<String, Object>>() {
        });
        System.out.println(address.get("city"));
        address.put("city", "San Francisco");

        /*
            The difference between using POJO and without POJO is, when we use POJO
            we can't add / remove fields in the JSON dynamically. But, when we use
            without POJO, we can dynamically add / remove fields in the JSON.
        */
        address.put("place", "23rd Jefferson St");
        // address.remove("place");
        String updatedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
        System.out.println(updatedJson);

        given()
                .contentType(ContentType.JSON)
                .body(address)
                .log()
                .all()
        .when()
                .post("https://www.example.com/")
        .then()
                .statusCode(200);
    }
}
