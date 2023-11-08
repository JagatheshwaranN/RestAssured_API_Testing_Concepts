package mock.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MockGetAPITestCase {

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    public static WireMockServer wireMockServer;

    @BeforeTest
    public void startupServer() {
        wireMockServer = new WireMockServer(PORT);
        wireMockServer.start();
        WireMock.configureFor(HOST, PORT);
        ResponseDefinitionBuilder responseDefinitionBuilder = new ResponseDefinitionBuilder();
        responseDefinitionBuilder.withStatus(200);
        responseDefinitionBuilder.withHeader("Content-Type", "application/json");
        responseDefinitionBuilder.withBodyFile("json/get_user.json");
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/user/emp101")).willReturn(responseDefinitionBuilder));
    }

    @AfterTest
    public void shutdownServer() {
        if (wireMockServer.isRunning() && null != wireMockServer) {
            wireMockServer.shutdownServer();
        }
    }

    @Test
    public void mockGetApiTest() {
        ValidatableResponse response =
                given()
                .when()
                        .get("http://localhost:8080/user/emp101")
                .then()
                        .assertThat()
                        .statusCode(200)
                        .log()
                        .all();

        Assert.assertEquals(response.extract().statusCode(), 200);
        Assert.assertEquals(response.extract().header("Content-Type"), "application/json");
        Assert.assertEquals(response.extract().jsonPath().get("worker.id"), "EMP101");
        Assert.assertEquals(response.extract().jsonPath().get("worker.name"), "John Doe");
        Assert.assertEquals(response.extract().jsonPath().get("worker.address.city"), "New York");
        Assert.assertEquals(response.extract().jsonPath().get("worker.address.country"), "United States");
        Assert.assertEquals(response.extract().jsonPath().get("worker.retrievedAt"), "2023-11-04T03:48:52.454Z");
    }

}
