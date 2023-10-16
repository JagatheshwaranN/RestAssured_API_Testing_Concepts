package _using_google_httpclient;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetMethodUsingGoogleHttpClientTest {

    @Test(priority = 1)
    public void getMethodUsingGoogleHttpClient(){

        HttpTransport transport;
        HttpRequest request;
        HttpResponse response;
        GenericUrl url;
        try {
            url = new GenericUrl("https://reqres.in/api/users/2");
            transport = new NetHttpTransport();
            request = transport.createRequestFactory().buildGetRequest(url);
            response = request.execute();
            System.out.println("Response Status Code    :" + response.getStatusCode());
            System.out.println("Response Status Message :" + response.getStatusMessage());
            System.out.println("Response Body :" + response.parseAsString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
