package authorization;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @restapi
 * @post
 */
public class BearerTokenTestCase {

    @Test(priority = 1)
    public void validateBearerToken(){

        String bearerToken = "1f022d017dc6883f06bad3e8df38886777b077d7130490242af5c92294af4bd9";

        HashMap<String, Object> userData = new HashMap<>();
        userData.put("name", "Adam");
        userData.put("gender", "male");
        userData.put("email", "adam@test.com");
        userData.put("status", "inactive");

        given()
                .headers("Authorization", "Bearer "+bearerToken)
                .contentType("application/json")
                .body(userData)
        .when()
                .post("https://gorest.co.in/public/v2/users/")
        .then()
                .statusCode(201)
                .body("name", equalTo("Adam"))
                .log().body();
    }
}
