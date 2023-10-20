package response.retrieve;

import io.restassured.response.Response;
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
public class RetrieveResponseInDifferentFormTestCase {

    @Test(priority = 1)
    public void retrieveResponseAsString(){

        Response response =
        given()
        .when()
                .get("https://reqres.in/api/users/2");

        String responseAsString = response.asString();
        System.out.println(responseAsString);
    }

    @Test(priority = 2)
    public void retrieveResponseAsPrettyString(){

        Response response =
                given()
                .when()
                        .get("https://reqres.in/api/users/2");

        String responseAsString = response.asPrettyString();
        System.out.println(responseAsString);
    }

    @Test(priority = 3)
    public void retrieveResponseAsInputStream() {

        Response response =
                given()
                .when()
                        .get("https://reqres.in/api/users/2");

        InputStream responseAsStream = response.asInputStream();
        String responseFromInputStream = new BufferedReader(new InputStreamReader(responseAsStream))
                .lines().collect(Collectors.joining());
        System.out.println(responseFromInputStream);
    }

    @Test(priority = 4)
    public void retrieveResponseAsByteArray() {

        Response response =
                given()
                .when()
                        .get("https://reqres.in/api/users/2");

        byte[] responseAsBytes = response.asByteArray();
        String responseFromBytes = new String(responseAsBytes, StandardCharsets.UTF_8);
        System.out.println(responseFromBytes);
    }

}
