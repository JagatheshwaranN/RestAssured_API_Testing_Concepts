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

public class ReadResponseFromJsonFileTestCase {

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    public static WireMockServer wireMockServer;

    @BeforeTest
    public void initializeServer() {
        wireMockServer = new WireMockServer(PORT);
        wireMockServer.start();
        WireMock.configureFor(HOST, PORT);
        ResponseDefinitionBuilder responseDefinitionBuilder = new ResponseDefinitionBuilder();
        responseDefinitionBuilder.withStatus(200);
        responseDefinitionBuilder.withHeader("Content-Type", "application/json");
        responseDefinitionBuilder.withHeader("Token", "98765");
        responseDefinitionBuilder.withHeader("Set-Cookie", "session_id=987654321");
        responseDefinitionBuilder.withBodyFile("json/worker.json");
        WireMock.stubFor(WireMock.get("/worker/1").willReturn(responseDefinitionBuilder));
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
                .get("http://localhost:8080/worker/1")
        .then()
                .assertThat()
                .statusCode(200)
                .log()
                .all();

        Assert.assertEquals(response.extract().statusLine(), "HTTP/1.1 200 OK");
        Assert.assertEquals(response.extract().header("Content-Type"), "application/json");
        Assert.assertEquals(response.extract().header("Set-Cookie"), "session_id=987654321");
        Assert.assertEquals(response.extract().jsonPath().get("worker.id"), "EMP101");
        Assert.assertEquals(response.extract().jsonPath().get("worker.name"), "John Doe");
        Assert.assertEquals(response.extract().jsonPath().get("worker.address.country"), "United States");
    }

}
