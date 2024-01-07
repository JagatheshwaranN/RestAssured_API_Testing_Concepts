package headers;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class HeadersUsageTest {

    @Test(priority = 1)
    public void sendHeaderUsingHeaderMethod(){

        ValidatableResponse response =
                given()
                        .header("Cache-Control", "no-cache")
                .when()
                        .get("https://reqres.in/api/users/2")
                .then()
                        .statusCode(200);
        System.out.println(response.extract().asPrettyString());
    }

    @Test(priority = 2)
    public void sendHeaderUsingHeaderObject(){

        Header header = new Header("Cache-Control", "no-cache");

        ValidatableResponse response =
                given()
                        .header(header)
                .when()
                        .get("https://reqres.in/api/users/2")
                .then()
                        .statusCode(200);
        System.out.println(response.extract().asPrettyString());
    }

    @Test(priority = 3)
    public void sendMultipleHeadersUsingHeaderMethod(){

        ValidatableResponse response =
                given()
                        .header("Cache-Control", "no-cache")
                        .header("Connection", "keep-alive")
                .when()
                        .get("https://reqres.in/api/users/2")
                .then()
                        .statusCode(200);
        System.out.println(response.extract().asPrettyString());
    }

    @Test(priority = 4)
    public void sendMultipleHeadersUsingHeadersMethod(){

        ValidatableResponse response =
                given()
                        .headers("Cache-Control", "no-cache",
                                "Connection", "keep-alive")
                .when()
                        .get("https://reqres.in/api/users/2")
                .then()
                        .statusCode(200);
        System.out.println(response.extract().asPrettyString());
    }

    @Test(priority = 5)
    public void sendMultipleHeadersUsingHeadersObject(){

        Header header1 = new Header("Cache-Control", "no-cache");
        Header header2 = new Header("Connection", "keep-alive");
        Headers headers = new Headers(header1, header2);

        ValidatableResponse response =
                given()
                        .headers(headers)
                .when()
                        .get("https://reqres.in/api/users/2")
                .then()
                        .statusCode(200);
        System.out.println(response.extract().asPrettyString());
    }

    @Test(priority = 6)
    public void sendMultipleHeadersUsingHeadersMapObject(){

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Cache-Control", "no-cache");
        headerMap.put("Connection", "keep-alive");

        ValidatableResponse response =
                given()
                        .headers(headerMap)
                        .when()
                        .get("https://reqres.in/api/users/2")
                        .then()
                        .statusCode(200);
        System.out.println(response.extract().asPrettyString());
    }

}
