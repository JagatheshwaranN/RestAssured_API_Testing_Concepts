package log;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @restapi
 * @get
 */
public class LogWhenValidationFailTestCase {

    @Test(priority = 1)
    public void generateLogWhenValidationFail(){
        given()
        .when()
                .log()
                .ifValidationFails()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

}
