package mock.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;

public class WireMockResponseTemplatingTestCase {

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    private static WireMockServer wireMockServer;

    private static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/__files/json/";

    @BeforeTest
    public void startServer() {
        wireMockServer = new WireMockServer(options().templatingEnabled(true));
        WireMock.configureFor(HOST, PORT);
        wireMockServer.start();
        JSONObject flightJson = new JSONObject(readJsonFile(FILE_PATH + "flight.json"));

        String responseBody = flightJson.getJSONObject("response").getJSONObject("jsonBody").toString(2);
        responseBody = new String(responseBody.getBytes(StandardCharsets.UTF_8));

        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/flights"))
                .willReturn(ResponseDefinitionBuilder.responseDefinition().withStatus(200)
                        .withBody(responseBody).withTransformers("response-template")));
    }

    @AfterTest
    public void shutdownServer() {
        if (wireMockServer.isRunning() && null != wireMockServer) {
            wireMockServer.shutdownServer();
        }
    }

    @Test(priority = 1)
    public void responseTemplatingTest() {
        ValidatableResponse response =
                given()
                .when()
                        .get("http://localhost:8080/flights?from=Chennai&to=Texas")
                .then()
                        .log().body();

        Assert.assertEquals(response.extract().statusCode(), 200);
    }

    private String readJsonFile(String fileName) {
        Path path = Paths.get(fileName);
        try {
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
