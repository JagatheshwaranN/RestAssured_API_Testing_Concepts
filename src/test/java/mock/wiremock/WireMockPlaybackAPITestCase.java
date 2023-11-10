package mock.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WireMockPlaybackAPITestCase {

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    public WireMockServer wireMockServer;

    public WireMock wireMock;

    @BeforeTest
    public void startupServer() {
        wireMockServer = new WireMockServer(PORT);
        WireMock.configureFor(HOST, PORT);
        wireMockServer.start();
    }

    @AfterTest
    public void shutdownServer() {
        if (wireMockServer.isRunning() && null != wireMockServer) {
            wireMockServer.shutdownServer();
        }
    }

    @Test
    public void verifyPlayBackApiTest() throws IOException {
        wireMock = new WireMock();
        String jsonString = Files.readString(Paths.get("src/test/resources/mappings/get--4880e29c-6507-4719-894c-d8e43c7268e3.json"), StandardCharsets.UTF_8);
        StubMapping stubMapping = StubMapping.buildFrom(jsonString);
        wireMock.register(stubMapping);
        Response response = RestAssured.get("http://localhost:8080/");
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), (200));
    }

}
