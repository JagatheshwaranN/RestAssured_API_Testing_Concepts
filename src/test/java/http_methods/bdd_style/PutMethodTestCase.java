package http_methods.bdd_style;

import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;

/**
 * @restapi
 * @put
 */
public class PutMethodTestCase {

    @Test(priority = 1)
    public void put(){

        HashMap<String, String> updateData = new HashMap<>();
        updateData.put("first_name", "John");
        updateData.put("last_name", "Smith");

        given()
                .contentType("application/json")
                .body(updateData)
        .when()
                .put("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .log().all();
    }
}
