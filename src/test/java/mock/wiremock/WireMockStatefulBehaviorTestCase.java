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

import static io.restassured.RestAssured.given;

public class WireMockStatefulBehaviorTestCase {

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    public static WireMockServer wireMockServer;

    public static String FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/__files/json/cart/";

    private String scenarioName;

    private String scenarioState;

    @BeforeTest
    public void startServer() {
        wireMockServer = new WireMockServer(PORT);
        wireMockServer.start();
        WireMock.configureFor(HOST, PORT);
    }

    @AfterTest
    public void shutdownServer() {
        if (wireMockServer.isRunning() && null != wireMockServer) {
            wireMockServer.shutdownServer();
        }
    }

    @Test(priority = 1)
    public void emptyCart() throws IOException {
        // Read the emptycart.json file
        JSONObject emptyCartJson = new JSONObject(readJsonFile(FILE_PATH + "emptycart.json"));

        // Update the scenario name and state from the JSON file
        scenarioName = emptyCartJson.getString("scenarioName");
        scenarioState = emptyCartJson.getString("requiredScenarioState");

        String responseBody = emptyCartJson.getJSONObject("response").toString(2);
        responseBody = new String(responseBody.getBytes(StandardCharsets.UTF_8));

        // Create a new WireMock stub for the empty cart scenario
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/cart-items"))
                .inScenario(scenarioName)
                .whenScenarioStateIs(scenarioState)
                .willReturn(ResponseDefinitionBuilder.responseDefinition().withStatus(200)
                        .withBody(responseBody)));

        // Make a GET request to the /cart-items endpoint
        ValidatableResponse response =
                given()
                .when()
                        .get("http://localhost:8080/cart-items")
                .then()
                        .log().body();

        // Assert that the response status code is 200
        Assert.assertEquals(response.extract().statusCode(), 200);
    }

    @Test(priority = 2)
    public void addCart() throws IOException {
        // Read the addcart.json file
        JSONObject addCartJson = new JSONObject(readJsonFile(FILE_PATH + "addcart.json"));

        // Update the scenario name and state from the JSON file
        scenarioName = addCartJson.getString("scenarioName");
        scenarioState = addCartJson.getString("requiredScenarioState");

        String responseBody = addCartJson.getJSONObject("response").toString(2);
        responseBody = new String(responseBody.getBytes(StandardCharsets.UTF_8));

        // Create a new WireMock stub for the add cart scenario
        WireMock.stubFor(WireMock.post(WireMock.urlPathEqualTo("/cart-items"))
                .inScenario(scenarioName)
                .whenScenarioStateIs(scenarioState)
                .withRequestBody(WireMock.containing(addCartJson.getJSONObject("request").
                        getJSONArray("bodyPatterns").getJSONObject(0).getString("contains")))
                .willReturn(ResponseDefinitionBuilder.responseDefinition().withStatus(201)
                        .withBody(responseBody))
                .willSetStateTo(addCartJson.getString("newScenarioState")));

        // Make a POST request to the /cart-items endpoint with the MicroService Architecture book
        ValidatableResponse response =
                given()
                        .body("MicroService Architecture")
                .when()
                        .post("http://localhost:8080/cart-items")
                .then()
                        .log().body();

        // Assert that the response status code is 201
        Assert.assertEquals(response.extract().statusCode(), 201);
    }

    @Test(priority = 3)
    public void fullCart() throws IOException {
        // Read the fullcart.json file
        JSONObject fullCartJson = new JSONObject(readJsonFile(FILE_PATH + "fullcart.json"));

        // Update the scenario name and state from the JSON file
        scenarioName = fullCartJson.getString("scenarioName");
        scenarioState = fullCartJson.getString("requiredScenarioState");

        String responseBody = fullCartJson.getJSONObject("response").toString(2);
        responseBody = new String(responseBody.getBytes(StandardCharsets.UTF_8));

        // Create a new WireMock stub for the full cart scenario
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/cart-items"))
                .inScenario(scenarioName)
                .whenScenarioStateIs(scenarioState)
                .willReturn(ResponseDefinitionBuilder.responseDefinition().withStatus(200)
                        .withBody(responseBody)));

        // Make a GET request to the /cart-items endpoint
        ValidatableResponse response =
                given()
                .when()
                        .get("http://localhost:8080/cart-items")
                .then()
                        .log().body();

        // Assert that the response status code is 200 and the response body contains the MicroService Architecture book
        Assert.assertEquals(response.extract().statusCode(), 200);
        Assert.assertTrue(response.extract().body().asString().contains("MicroService Architecture"));
    }

    @Test(priority = 4)
    public void deleteCart() throws IOException {
        // Read the deletecart.json file
        JSONObject deleteCartJson = new JSONObject(readJsonFile(FILE_PATH + "deletecart.json"));

        // Update the scenario name and state from the JSON file
        scenarioName = deleteCartJson.getString("scenarioName");
        scenarioState = deleteCartJson.getString("requiredScenarioState");

        String responseBody = deleteCartJson.getJSONObject("response").toString(2);
        responseBody = new String(responseBody.getBytes(StandardCharsets.UTF_8));

        // Create a new WireMock stub for the delete cart scenario
        WireMock.stubFor(WireMock.delete(WireMock.urlPathEqualTo("/cart-items"))
                .inScenario(scenarioName)
                .whenScenarioStateIs(scenarioState)
                .willReturn(ResponseDefinitionBuilder.responseDefinition().withStatus(204)
                        .withBody(responseBody))
                .willSetStateTo(deleteCartJson.getString("newScenarioState")));


        // Make a DELETE request to the /cart-items endpoint
        ValidatableResponse response =
                given()
                .when()
                        .delete("http://localhost:8080/cart-items")
                .then()
                        .log().body();

        // Assert that the response status code is 204
        Assert.assertEquals(response.extract().statusCode(), 204);
    }

    private static String readJsonFile(String fileName) throws IOException {
        Path path = Path.of(fileName);
        return Files.readString(path, StandardCharsets.UTF_8);
    }

}
