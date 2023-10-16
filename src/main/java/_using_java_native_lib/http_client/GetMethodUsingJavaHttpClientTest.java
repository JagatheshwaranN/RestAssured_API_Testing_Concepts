package _using_java_native_lib.http_client;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GetMethodUsingJavaHttpClientTest {

    @Test(priority = 1)
    public void getMethodUsingJavaHttpClientApproach1() {

        HttpClient httpClient;
        HttpRequest request;
        HttpResponse<String> response;
        try {
            httpClient = HttpClient.newHttpClient();
            request = HttpRequest.newBuilder()
                    .uri(new URI("https://reqres.in/api/users/2"))
                    .GET()
                    .build();
            response = httpClient
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Status Code :" + response.statusCode());
            System.out.println("Response Body        :" + response.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 2)
    public void getMethodUsingJavaHttpClientApproach2() {

        HttpClient httpClient;
        HttpRequest request;
        HttpResponse<String> response;
        URI uri;
        try {
            uri = URI.create("https://reqres.in/api/users/2");
            httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            response = httpClient
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Status Code :" + response.statusCode());
            System.out.println("Response Body        :" + response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
