package _using_apache_httpclient.fluent;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class PostMethodUsingApacheHttpClientTest {

    @Test(priority = 1)
    public void postMethodUsingApacheHttpClientFluent() throws IOException {
        String payloadJson = """ 
                                {
                                   "name":"John",
                                   "job":"Tester"
                                  }
                                """;
        Response response = Request.post("https://reqres.in/api/users").
                bodyString(payloadJson, ContentType.APPLICATION_JSON).execute();
        APIResponse httpResponse = response.handleResponse(handler ->
                new APIResponse(EntityUtils.toString(handler.getEntity()), handler));
        System.out.println("Response Status Code    :" + httpResponse.responseContainer.getCode());
        System.out.println("Response Status Message :" + httpResponse.responseContainer.getReasonPhrase());
        System.out.println("Response Body :" + httpResponse.responseBody);
    }

    record APIResponse(String responseBody, ClassicHttpResponse responseContainer) {
    }
}
