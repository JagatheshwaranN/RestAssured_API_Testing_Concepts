package mock.wiremock;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class WireMockCloudDynamicResponseTestCase {

    @Test(priority = 1)
    public void cloudDynamicResponseTest() {
        ValidatableResponse response =
                given()
                        .queryParam("from", "Chennai")
                        .queryParam("to", "California")
                .when()
                        .get("https://testautomation.wiremockapi.cloud/flights")
                .then()
                        .log().body();

        Assert.assertEquals(response.extract().statusCode(), 200);
    }

}
