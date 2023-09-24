package payload;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @restapi
 * @post
 * @dummy
 */
public class NestedJsonPayloadTestCase {

    @Test(priority = 1)
    public void nestedJsonPayloadTest(){

        Map<String, Object> address = new HashMap<>();
        address.put("city", "seattle");
        address.put("state", "USA");

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("id", 101);
        nestedJson.put("name", "John");
        nestedJson.put("email", "john@test.com");
        nestedJson.put("address", address);

        RestAssured.baseURI = "https://www.example.com/";
        RestAssured.given().log().all().body(nestedJson).post();
    }
}
