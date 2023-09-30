package payload;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @post
 */
public class DynamicPayloadUsingJacksonAnnotationAtPropertyLevelPojoTestCase {

    @Test(priority = 1)
    public void postUsingJsonWithJacksonAnnotationAtPropertyLevel() throws IOException {

        Address4 address = new Address4();
        address.setCity(null);
        address.setZipcode(0);
        address.setLandmark(new ArrayList<>());
        address.setState("California");
        address.setCountry("United States");

        ObjectMapper objectMapper = new ObjectMapper();
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

    @Test(priority = 2)
    public void postUsingJsonWithJacksonPropertiesAnnotation() throws IOException {

        Address5 address = new Address5();
        address.setCity("San Francisco");
        address.setZipcode(10001);
        address.setState("California");
        address.setCountry("United States");

        ObjectMapper objectMapper = new ObjectMapper();
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

    @Test(priority = 3)
    public void postUsingJsonWithJacksonPropertiesAnnotationFromChildClass() throws IOException {

        BillingAddress address = new BillingAddress();
        address.setCity("San Francisco");
        address.setZipcode(10001);
        address.setLandmark(new ArrayList<>(List.of("Near StarBucks")));
        address.setState("California");
        address.setCountry("United States");

        ObjectMapper objectMapper = new ObjectMapper();
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
