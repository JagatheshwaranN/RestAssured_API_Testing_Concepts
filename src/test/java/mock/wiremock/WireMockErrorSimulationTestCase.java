package mock.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Fault;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WireMockErrorSimulationTestCase {

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

    @Test(enabled = false)
    public void verifyInternalServerErrorTest() {
        WireMock.stubFor(WireMock.any(WireMock.urlPathEqualTo("/user/emp102")).willReturn(WireMock.serverError()));
        Response response = RestAssured.get("http://localhost:8080/user/emp102");
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        Assert.assertEquals(response.getStatusCode(), 500);
    }

    @Test
    public void verifyMalformedUrlErrorTest() {
        WireMock.stubFor(WireMock.any(WireMock.urlPathEqualTo("/user/emp103")).willReturn(WireMock.aResponse().withFault(Fault.MALFORMED_RESPONSE_CHUNK)));

    }

}
