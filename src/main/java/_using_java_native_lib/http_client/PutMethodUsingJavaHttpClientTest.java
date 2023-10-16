package _using_java_native_lib.http_client;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PutMethodUsingJavaHttpClientTest {

    @Test(priority = 1)
    public void putMethodUsingJavaHttpClient(){

        String payloadJson = """ 
                                {
                                   "name":"John",
                                   "job":"Automation Tester"
                                  }
                                """;
        HttpClient httpClient;
        HttpRequest request;
        HttpResponse<String> response;
        try {
            httpClient = HttpClient.newHttpClient();
            request = HttpRequest.newBuilder()
                    .uri(new URI("https://reqres.in/api/users/2"))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(payloadJson))
                    .build();
            response = httpClient
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Status Code :" + response.statusCode());
            System.out.println("Response Body        :" + response.body());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
