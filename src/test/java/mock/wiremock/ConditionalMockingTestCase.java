package mock.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static io.restassured.RestAssured.given;

public class ConditionalMockingTestCase {

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    public static WireMockServer wireMockServer;

    @BeforeTest
    public void initializeServer() {
        wireMockServer = new WireMockServer(PORT);
        wireMockServer.start();
        WireMock.configureFor(HOST, PORT);
        ResponseDefinitionBuilder responseDefinitionBuilder1 = new ResponseDefinitionBuilder();
        responseDefinitionBuilder1.withStatus(503);
        responseDefinitionBuilder1.withHeader("Content-Type", "text/html");
        responseDefinitionBuilder1.withBody("Service Not Available");
        WireMock.stubFor(WireMock.get("/worker/1").willReturn(responseDefinitionBuilder1));

        ResponseDefinitionBuilder responseDefinitionBuilder2 = new ResponseDefinitionBuilder();
        responseDefinitionBuilder2.withStatus(200);
        responseDefinitionBuilder2.withHeader("Content-Type", "application/json");
        responseDefinitionBuilder2.withBody("""
                {
                  "current-status": "running"
                }""");
        responseDefinitionBuilder2.withFixedDelay(2500);
        WireMock.stubFor(WireMock.get("/movies/1").withHeader("Accept", matching("text/plain")).willReturn(responseDefinitionBuilder1));
        WireMock.stubFor(WireMock.get("/movies/1").withHeader("Accept", matching("application/json")).willReturn(responseDefinitionBuilder2));
    }

    @AfterTest
    public void shutdownServer() {
        if (wireMockServer.isRunning() && null != wireMockServer) {
            wireMockServer.shutdownServer();
        }
    }

    @Test(priority = 1)
    public void mockGetApiType1Test() {
        ValidatableResponse response =
                given()
                        .header("Accept", "text/plain")
                .when()
                        .get("http://localhost:8080/movies/1")
                .then()
                        .assertThat()
                        .statusCode(503)
                        .log()
                        .all();
        Assert.assertTrue(response.extract().body().asString().contains("Service Not Available"));
    }

    @Test(priority = 2)
    public void mockGetApiType2Test() {
        ValidatableResponse response =
                given()
                        .header("Accept", "application/json")
                .when()
                        .get("http://localhost:8080/movies/1")
                .then()
                        .assertThat()
                        .statusCode(200)
                        .log()
                        .all();
        Assert.assertEquals(response.extract().body().jsonPath().get("current-status"), "running");
    }


}
