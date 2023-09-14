package log;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @restapi
 * @get
 */
public class LoggingTestCase {

    @Test(priority = 1)
    public void logTestCase() {

        // Logging Headers only
        logHeaders();

        // Logging Cookies only
        logCookies();

        // Logging Body only
        logBody();

        // Logging Status only
        logStatus();
    }

    void logHeaders(){
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .log().headers();
    }

    void logCookies(){
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .log().cookies();
    }

    void logBody(){
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .log().body();
    }

    void logStatus(){
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .log().status();
    }
}
