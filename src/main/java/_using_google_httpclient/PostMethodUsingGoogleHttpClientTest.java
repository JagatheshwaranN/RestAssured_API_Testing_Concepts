package _using_google_httpclient;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PostMethodUsingGoogleHttpClientTest {

    @Test(priority = 1)
    public void postMethodUsingGoogleHttpClient(){

        HttpTransport transport;
        HttpRequest request;
        HttpResponse response;
        HttpContent content;
        GenericUrl url;
        JsonFactory jsonFactory;
        Map<String, Object> data = new HashMap<>();
        try {
            url = new GenericUrl("https://reqres.in/api/users");
            transport = new NetHttpTransport();
            jsonFactory = new GsonFactory();
            data.put("name", "John");
            data.put("job", "Tester");
            content = new JsonHttpContent(jsonFactory, data);
            request = transport.createRequestFactory().buildPostRequest(url, content);
            response = request.execute();
            System.out.println("Response Status Code    :" + response.getStatusCode());
            System.out.println("Response Status Message :" + response.getStatusMessage());
            System.out.println("Response Body :" + response.parseAsString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
