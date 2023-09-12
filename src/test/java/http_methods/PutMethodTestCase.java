package http_methods;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


/**
 * @restapi
 * @put
 */
public class PutMethodTestCase {

    @Test(priority = 1, enabled = true)
    public void put(){

        HashMap<String, String> updateData = new HashMap<>();
        updateData.put("name", "John");
        updateData.put("job", "Senior Tester");

        given()
            .contentType("application/json")
            .body(updateData)
        .when()
            .put("https://reqres.in/api/users/126")
        .then()
            .statusCode(200)
            .log().all();
    }
}
