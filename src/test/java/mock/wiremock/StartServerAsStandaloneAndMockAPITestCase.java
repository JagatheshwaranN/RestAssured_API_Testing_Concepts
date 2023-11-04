package mock.wiremock;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 * @mock
 */
public class StartServerAsStandaloneAndMockAPITestCase {

    @Test(priority = 1)
    public void mockGetApiResponseTest() {

        given()
        .when()
                .get("http://localhost:8080/user/1")
        .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test(priority = 2)
    public void mockGetApiResponseHeaderTest() {
        ValidatableResponse response =
                given()
                .when()
                        .get("http://localhost:8080/user/2")
                .then()
                        .statusCode(200)
                        .log()
                        .all();

        String contentType = response.extract().header("Content-Type");
        System.out.println("Response Content Type : " + contentType);
        Assert.assertEquals(contentType, "text/plain");
    }

}
