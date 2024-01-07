package headers;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class ValidateResponseHeadersTestCase {

    @Test(priority = 1)
    public void validateResponseHeaderInfo(){

        ValidatableResponse response =
                given()
                .when()
                        .get("https://reqres.in/api/users/2")
                .then()
                        .assertThat()
                        .statusCode(200)
                        .header("Content-Type", "application/json; charset=utf-8");
        System.out.println(response.extract().asPrettyString());
    }

    @Test(priority = 2)
    public void validateResponseHeadersInfo(){

        ValidatableResponse response =
                given()
                .when()
                        .get("https://reqres.in/api/users/2")
                .then()
                        .assertThat()
                        .statusCode(200)
                        .headers("Content-Type", "application/json; charset=utf-8", "Transfer-Encoding", "chunked");
        System.out.println(response.extract().asPrettyString());
    }

    @Test(priority = 3)
    public void validateResponseHeadersMapInfo(){

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Transfer-Encoding", "chunked");
        headerMap.put("Connection", "keep-alive");

        ValidatableResponse response =
                given()
                .when()
                        .get("https://reqres.in/api/users/2")
                .then()
                        .assertThat()
                        .statusCode(200)
                        .headers(headerMap);
        System.out.println(response.extract().asPrettyString());
    }

}
