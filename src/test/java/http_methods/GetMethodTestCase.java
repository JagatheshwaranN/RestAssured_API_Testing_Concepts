package http_methods;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

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
