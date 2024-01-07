package headers;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class ExtractResponseHeadersTestCase {

    @Test(priority = 1)
    public void getResponseHeaderInfo(){

        ValidatableResponse response =
                given()
                .when()
                        .get("http://localhost:3000/students/1")
                .then()
                        .statusCode(200);

        System.out.println(response.extract().header("Content-Type"));
    }

    @Test(priority = 2)
    public void getResponseHeadersInfo(){

        ValidatableResponse response =
                given()
                .when()
                        .get("http://localhost:3000/students/1")
                .then()
                        .statusCode(200);

        Headers headers = response.extract().headers();
        for (Header header : headers){
            System.out.println(header.getName()+ " : "+header.getValue());
        }
    }

}
