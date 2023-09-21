package http_methods.bdd_style;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @restapi
 * @post
 */
public class PostMethodTestCase {

    @Test(priority = 1)
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
