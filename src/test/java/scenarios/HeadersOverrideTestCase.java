package scenarios;

import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HeadersOverrideTestCase {

    @Test(priority = 1)
    public void headersOverrideTest() {

        given()
                .header("Content-Type", "application/xml")
                .header("Content-Type", "application/json")
                .config(RestAssuredConfig.config().
                        headerConfig(HeaderConfig.headerConfig().
                                overwriteHeadersWithName("Content-Type")))
                .log().headers()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .log().body();
    }

}
