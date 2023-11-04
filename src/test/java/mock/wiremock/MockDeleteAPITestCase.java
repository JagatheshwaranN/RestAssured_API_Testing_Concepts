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

public class MockDeleteAPITestCase {

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    public static WireMockServer wireMockServer;

    @BeforeTest
    public void startupServer() {
        wireMockServer = new WireMockServer(PORT);
        wireMockServer.start();
        WireMock.configureFor(HOST, PORT);
        ResponseDefinitionBuilder responseDefinitionBuilder = new ResponseDefinitionBuilder();
        responseDefinitionBuilder.withStatus(204);
        responseDefinitionBuilder.withHeader("Content-Type", "application/json");
        responseDefinitionBuilder.withBodyFile("json/delete_user.json");
        WireMock.stubFor(WireMock.delete(WireMock.urlPathMatching("/user/.*")).willReturn(responseDefinitionBuilder));
    }

    @AfterTest
    public void shutdownServer() {
        if (wireMockServer.isRunning() && null != wireMockServer) {
            wireMockServer.shutdownServer();
        }
    }

    @Test
    public void mockDeleteApiTest() {
        ValidatableResponse response =
                given()
                .when()
                        .delete("http://localhost:8080/user/emp101")
                .then()
                        .assertThat()
                        .statusCode(204)
                        .log()
                        .all();

        Assert.assertEquals(response.extract().statusCode(), 204);
        Assert.assertEquals(response.extract().header("Content-Type"), "application/json");
    }

}
