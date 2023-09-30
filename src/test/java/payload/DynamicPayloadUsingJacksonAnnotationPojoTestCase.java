package payload;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojo.Address1;
import pojo.Address2;
import pojo.Address3;
import pojo.Address4;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @post
 */
public class DynamicPayloadUsingJacksonAnnotationPojoTestCase {

    @Test(priority = 1)
    public void postUsingJsonWithJacksonNonDefaultAnnotation() throws IOException {

        Address1 address = new Address1();
        address.setCity("San Francisco");
        address.setState("California");
        address.setZipcode(0);
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
    public void postUsingJsonWithJacksonNonNullAnnotation() throws IOException {

        Address2 address = new Address2();
        address.setCity("San Francisco");
        address.setState(null);
        address.setZipcode(10001);
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
    public void postUsingJsonWithJacksonNonEmptyAnnotation() throws IOException {

        Address3 address = new Address3();
        address.setCity("San Francisco");
        address.setZipcode(10001);
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

    @Test(priority = 4)
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

}
