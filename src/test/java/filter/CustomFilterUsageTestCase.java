package filter;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CustomFilterUsageTestCase {

    @Test(priority = 1)
    public void customFilter(){
        RestAssured.filters(new CustomHeaderFilter("Header1", "Header1Value"));
        given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .log().headers()
        .when()
                .get("/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

}
