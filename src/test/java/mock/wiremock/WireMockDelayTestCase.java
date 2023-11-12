package mock.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WireMockDelayTestCase {

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    public static WireMockServer wireMockServer;

    @BeforeTest
    public void startupServer() {
        wireMockServer = new WireMockServer(PORT);
        WireMock.configureFor(HOST, PORT);
        wireMockServer.start();
        WireMock.stubFor(WireMock.any(WireMock.anyUrl()).willReturn(WireMock.aResponse().proxiedFrom("http://localhost:3000/students/2").withFixedDelay(5000)));

    }

    @AfterTest
    public void shutdownServer() {
        if (wireMockServer.isRunning() && null != wireMockServer) {
            wireMockServer.shutdownServer();
        }
    }

    @Test
    public void verifyDelayTest() {
        ValidatableResponse response =
                given()
                        .when()
                        .get("http://localhost:8080")
                        .then()
                        .statusCode(200)
                        .body("id", equalTo(2));

        System.out.println(response.extract().asPrettyString());
        Assert.assertEquals(response.extract().body().jsonPath().getInt("id"), 2);
    }


}
