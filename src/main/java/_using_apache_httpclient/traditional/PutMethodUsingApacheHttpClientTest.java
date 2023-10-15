package _using_apache_httpclient.traditional;


import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

public class PutMethodUsingApacheHttpClientTest {

    @Test(priority = 1)
    public void putMethodUsingApacheHttpClient() throws IOException {
        String payloadJson = """ 
                                {
                                   "name":"John",
                                   "job":"Automation Tester"
                                  }
                                """;
        HttpClient httpClient = HttpClients.createDefault();
        HttpPut request = new HttpPut("https://reqres.in/api/users/2");
        request.setEntity(new StringEntity(payloadJson, ContentType.APPLICATION_JSON));
        APIResponse response = httpClient.execute(request, httpResponse ->
                new APIResponse(EntityUtils.toString(httpResponse.getEntity()),httpResponse));
        System.out.println("Response Status Code    :" + response.responseContainer.getCode());
        System.out.println("Response Status Message :" + response.responseContainer.getReasonPhrase());
        System.out.println("Response Body :" + response.responseBody);
    }
    record APIResponse(String responseBody, ClassicHttpResponse responseContainer){

    }

}
