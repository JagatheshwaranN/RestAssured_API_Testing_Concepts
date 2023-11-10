package mock.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WiremockPlaybackExample {

    public static void main(String[] args) throws IOException {
        WireMockServer wireMockServer = new WireMockServer(8080);
        WireMock.configureFor("localhost", 8080);
        wireMockServer.start();

        String content = Files.readString(Paths.get("src/test/resources/mappings/get--990c6141-f0ca-4c2f-96f0-4184668d9ddd.json"), StandardCharsets.UTF_8);

        // Pass the JSON file to the StubMapping.buildFrom() method
        StubMapping stubMappingBuilder = StubMapping.buildFrom(content);

        // Register the stub mapping with WireMock
        new WireMock().register(stubMappingBuilder);

        // Make a request to the mocked API
        Response response = RestAssured.get("http://localhost:8080");
        response.prettyPrint();

        // Verify that the response from the mocked API is correct
        Assert.assertEquals(response.getStatusCode(), (200));

        // Stop the WireMock server after the test is completed
        wireMockServer.stop();

    }
}
