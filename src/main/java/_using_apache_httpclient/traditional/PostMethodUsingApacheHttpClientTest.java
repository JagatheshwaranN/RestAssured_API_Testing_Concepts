package _using_apache_httpclient.traditional;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

public class PostMethodUsingApacheHttpClientTest {

    @Test(priority = 1)
    public void postMethodUsingApacheHttpClient() throws IOException {
        String payloadJson = """ 
                                {
                                   "name":"John",
                                   "job":"Tester"
                                  }
                                """;
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost("https://reqres.in/api/users");
        request.setEntity(new StringEntity(payloadJson, ContentType.APPLICATION_JSON));
        APIResponse response = httpClient.execute(request,
                httpResponse -> new APIResponse(EntityUtils.toString(httpResponse.getEntity()), httpResponse));
        System.out.println(response.responseContainer.getCode());
        System.out.println(response.responseContainer.getReasonPhrase());
        System.out.println(response.responseBody);
        System.out.println(Arrays.toString(response.responseContainer.getHeaders()));
    }

    record APIResponse(String responseBody, ClassicHttpResponse responseContainer) {
    }

}

