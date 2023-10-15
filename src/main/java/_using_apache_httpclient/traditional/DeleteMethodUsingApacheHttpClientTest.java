package _using_apache_httpclient.traditional;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteMethodUsingApacheHttpClientTest {

    @Test(priority = 1)
    public void deleteMethodUsingApacheHttpClient() throws IOException {

        HttpClient httpClient = HttpClients.createDefault();
        HttpDelete request = new HttpDelete("https://reqres.in/api/users/2");
        ClassicHttpResponse response = httpClient.execute(request, httpResponse -> httpResponse);
        int statusCode = response.getCode();
        String statusMessage = response.getReasonPhrase();
        System.out.println("Response Status Code    :" + statusCode);
        System.out.println("Response Status Message :" + statusMessage);
    }

}
