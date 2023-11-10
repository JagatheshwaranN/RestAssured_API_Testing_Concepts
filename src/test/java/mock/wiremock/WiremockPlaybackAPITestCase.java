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

public class WiremockPlaybackAPITestCase {

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    public static WireMockServer wireMockServer;

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
        String content = Files.readString(Paths.get("src/test/resources/mappings/get--36a80e49-32a8-4f84-8872-793b103df6c6.json"), StandardCharsets.UTF_8);
        StubMapping stubMappingBuilder = StubMapping.buildFrom(content);
        new WireMock().register(stubMappingBuilder);
        Response response = RestAssured.get("http://localhost:8080");
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), (200));
    }

}
