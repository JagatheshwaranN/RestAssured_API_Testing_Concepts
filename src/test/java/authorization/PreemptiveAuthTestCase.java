package authorization;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @restapi
 * @get
 */
public class PreemptiveAuthTestCase {

    @Test(priority = 1)
    public void validatePreemptiveAuth() {

        given()
                .auth().preemptive().basic("postman","password")
        .when()
                .get("https://postman-echo.com/basic-auth")
        .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().body();
    }
}
