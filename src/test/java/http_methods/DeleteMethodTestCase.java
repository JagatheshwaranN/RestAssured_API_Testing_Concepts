package http_methods;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * @restapi
 * @delete
 */
public class DeleteMethodTestCase {

    @Test(priority = 1, enabled = true)
    public void delete(){

        given()
        .when()
                .delete("https://reqres.in/api/users/126")
        .then()
                .statusCode(204)
                .log().all();
    }
}
