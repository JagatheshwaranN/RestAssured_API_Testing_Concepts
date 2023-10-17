package async;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ConnectionTimeOutTestCase {

    @Test(priority = 1)
    public void connectionTimeOut(){

        /*
            This method is not working and issue is in open status.

            RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000)
                .build();

            HttpClientConfig httpClientConfig = HttpClientConfig.httpClientConfig()
                .httpClientFactory(() -> HttpClientBuilder.create()
                        .setDefaultRequestConfig(requestConfig).build());
        */

        HttpClientConfig httpClientConfig = HttpClientConfig.httpClientConfig()
                .setParam("http.connection.timeout", 5000)
                .setParam("http.socket.timeout", 5000);

        RestAssuredConfig config = RestAssured.config().httpClient(httpClientConfig);

        given()
                .config(config)
        .when()
                .get("https://reqres.in/api/users/2?delay=4")
        .then()
                .statusCode(200)
                .log().all();
    }

}
