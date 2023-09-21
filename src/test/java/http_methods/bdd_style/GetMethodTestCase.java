package http_methods.bdd_style;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @restapi
 * @get
 */
public class GetMethodTestCase {

    @Test(priority = 1)
    public void get(){

        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .log().all();
    }
}
