package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class PathParameterTestCase {

    @Test(priority = 1)
    public void pathParam(){

        given()
                .pathParam("id", "1")
        .when()
                .get("http://localhost:3000/students/{id}")
        .then()
                .statusCode(200)
                .log()
                .all();
    }
}
