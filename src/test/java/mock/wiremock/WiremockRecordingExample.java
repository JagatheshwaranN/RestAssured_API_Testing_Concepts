package mock.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Arrays;

public class WiremockRecordingExample {

    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(8080);
        wireMockServer.start();

        // Start recording requests
        WireMock.startRecording("http://localhost:3000/students/1");

        // Make a request to the API you want to record from
        Response response = RestAssured.get("http://localhost:8080/");

        // Stop recording requests
        WireMock.stopRecording();

        // Save the recorded stub mappings to a file
        WireMock.saveAllMappings();

        // Get the recorded stub mapping
        StubMapping[] stubMappings = wireMockServer.getStubMappings().toArray(new StubMapping[0]);

        System.out.println(Arrays.toString(stubMappings));

        // Verify that the recorded stub mapping is correct
//        Assert.assertEquals(stubMappings[0].getRequest().getMethod().getName(),"GET");
//        Assert.assertEquals(stubMappings[0].getRequest().getUrl(), "/api/users");
//        Assert.assertEquals(stubMappings[0].getResponse().getStatus(),response.getStatusCode());

        wireMockServer.stop();
    }
}

