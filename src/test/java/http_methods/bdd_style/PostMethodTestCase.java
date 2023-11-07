package http_methods.bdd_style;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

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
