package scenarios;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FileDownloadTestCase {

    @Test(priority = 1)
    public void fileDownloadTestCase(){

        ValidatableResponse response =
        given()
        .when()
                .get("https://the-internet.herokuapp.com/download/local.env.txt")
        .then()
                .statusCode(200)
                .log()
                .body();
        System.out.println(response.extract().body().asString());
    }
}
