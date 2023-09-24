package payload;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @restapi
 * @post
 * @dummy
 */
public class SimpleJsonArrayPayloadTestCase {

    @Test(priority = 1)
    public void simpleJsonArrayPayloadTest(){

        Map<String, Object> simpleJson1 = new HashMap<>();
        simpleJson1.put("id", 101);
        simpleJson1.put("name", "John");
        simpleJson1.put("email", "john@test.com");

        Map<String, Object> simpleJson2 = new HashMap<>();
        simpleJson2.put("id", 102);
        simpleJson2.put("name", "Alex");
        simpleJson2.put("email", "alex@test.com");

        List<Map<String, Object>> jsonArray = new ArrayList<>();
        jsonArray.add(simpleJson1);
        jsonArray.add(simpleJson2);

        RestAssured.baseURI = "https://www.example.com/";
        RestAssured.given().log().all().body(jsonArray).post();
    }

}
