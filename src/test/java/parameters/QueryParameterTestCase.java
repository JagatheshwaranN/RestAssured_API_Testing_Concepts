package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameterTestCase {

    @Test(priority = 1)
    public void queryParam(){

        given()
                .queryParam("page","2")
        .when()
                .get("https://reqres.in/api/users")
        .then()
                .statusCode(200)
                .log()
                .all();
    }
}
