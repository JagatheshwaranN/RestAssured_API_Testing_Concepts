package _using_apache_httpclient;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

public class GetMethodUsingApacheHttpClientTest {

    @Test(priority = 1)
    public void getMethodUsingApacheHttpClientApproach1() throws IOException, ParseException {

        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://reqres.in/api/users/2");
        ClassicHttpResponse response = httpClient.execute(request, httpResponse -> {

            int statusCode = httpResponse.getCode();
            String statusMessage = httpResponse.getReasonPhrase();
            String responseBody = EntityUtils.toString(httpResponse.getEntity());
            System.out.println("Response Status Code    :"+statusCode);
            System.out.println("Response Status Message :"+statusMessage);
            System.out.println("Response Body :"+responseBody);
            return httpResponse;
        });
        System.out.println(Arrays.toString(response.getHeaders()));
    }
}

