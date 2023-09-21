package authorization.bdd_style;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * @restapi
 * @get
 */
public class BasicAuthTestCase {

    @Test(priority = 1)
    public void validateBasicAuth() {

        given()
                .auth().basic("postman","password")
        .when()
                .get("https://postman-echo.com/basic-auth")
        .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().body();
    }
}
