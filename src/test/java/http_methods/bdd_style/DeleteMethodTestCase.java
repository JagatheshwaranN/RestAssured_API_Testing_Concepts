package http_methods.bdd_style;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

/**
 * @restapi
 * @delete
 */
public class DeleteMethodTestCase {

    @Test(priority = 1)
    public void delete(){

        given()
        .when()
                .delete("https://reqres.in/api/users/126")
        .then()
                .statusCode(204)
                .log().all();
    }
}
