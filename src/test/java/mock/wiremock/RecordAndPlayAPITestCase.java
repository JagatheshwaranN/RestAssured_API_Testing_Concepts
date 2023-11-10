package mock.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RecordAndPlayAPITestCase {

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    public static WireMockServer wireMockServer;

    @BeforeTest
    public void startupServer() {
        wireMockServer = new WireMockServer(PORT);
        WireMock.configureFor(HOST, PORT);
        wireMockServer.start();
        wireMockServer.startRecording("http://localhost:3000/students/1");
    }

    @AfterTest
    public void shutdownServer() {
        if (wireMockServer.isRunning() && null != wireMockServer) {
            wireMockServer.stopRecording();
            wireMockServer.shutdownServer();
        }
    }

    @Test
    public void verifyMockPostApiTest() {

        given()
                .when()
                .get("http://localhost:3000/students/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .log().all();
    }

}
