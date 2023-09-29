package payload;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojo.Address;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @post
 */
public class PayloadUsingExternalJsonAndPojoTestCase {

    @Test(priority = 1)
    public void postUsingJsonAndPojoWithJacksonAsPayload() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Address address = objectMapper.readValue(new File("src//test//resources//address.json"), Address.class);
        System.out.println(address.getCity());
        address.setCity("San Francisco");

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
