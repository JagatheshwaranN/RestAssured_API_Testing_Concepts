package http_methods;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @restapi
 * @post
 */
public class PostMethodTestCase {

    @Test(priority = 1, enabled = true)
    public void post(){

        HashMap<String, String> userData = new HashMap<>();
        userData.put("name", "John");
        userData.put("job", "Tester");

        given()
                .contentType("application/json")
                .body(userData)
        .when()
                .post("https://reqres.in/api/users")
        .then()
                .statusCode(201)
                .log().all();
    }
}
