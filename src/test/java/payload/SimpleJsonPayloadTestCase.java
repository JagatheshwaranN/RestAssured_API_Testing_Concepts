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
public class SimpleJsonPayloadTestCase {

    @Test(priority = 1)
    public void simpleJsonPayloadTest(){

        Map<String, Object> simpleJson = new HashMap<>();
        simpleJson.put("id", 101);
        simpleJson.put("name", "John");
        simpleJson.put("email", "john@test.com");

        RestAssured.baseURI = "https://www.example.com/";
        RestAssured.given().log().all().body(simpleJson).post();
    }
}
