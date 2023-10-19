package response.retrieve;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class RetrieveValidatableResponseInDifferentFormTestCase {

    @Test(priority = 1)
    public void retrieveValidatableResponseAsString(){

        ValidatableResponse response =
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200);

        String responseAsString = response.extract().asString();
        System.out.println(responseAsString);
    }

    @Test(priority = 2)
    public void retrieveValidatableResponseAsPrettyString(){

        ValidatableResponse response =
                given()
                .when()
                        .get("https://reqres.in/api/users/2")
                .then()
                        .statusCode(200);

        String responseAsString = response.extract().asPrettyString();
        System.out.println(responseAsString);
    }

    @Test(priority = 3)
    public void retrieveValidatableResponseAsInputStream() {

        ValidatableResponse response =
                given()
                .when()
                        .get("https://reqres.in/api/users/2")
                .then()
                        .statusCode(200);

        InputStream responseAsStream = response.extract().asInputStream();
        String responseFromInputStream = new BufferedReader((new InputStreamReader(responseAsStream))).lines().collect(Collectors.joining());
        System.out.println(responseFromInputStream);
    }

    @Test(priority = 4)
    public void retrieveValidatableResponseAsByteArray() {

        ValidatableResponse response =
                given()
                .when()
                        .get("https://reqres.in/api/users/2")
                .then()
                        .statusCode(200);

        byte[] responseAsBytes = response.extract().asByteArray();
        String responseFromBytes = new String(responseAsBytes, StandardCharsets.UTF_8);
        System.out.println(responseFromBytes);
    }

}
