package http_methods.bdd_style;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @patch
 */
public class PatchMethodTestCase {

    @Test(priority = 1)
    public void patch(){

        HashMap<String, String> updateData = new HashMap<>();
        updateData.put("first_name", "Smith");

        given()
                .contentType("application/json")
                .body(updateData)
        .when()
                .patch("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .log().all();
    }

}
