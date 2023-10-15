package _using_apache_httpclient.fluent;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetMethodUsingApacheHttpClientTest {

    @Test(priority = 1)
    public void getMethodUsingApacheHttpClientFluentApproach1() throws IOException {

        Response response = Request.get("https://reqres.in/api/users/2").execute();
        HttpResponse httpResponse = response.returnResponse();
        System.out.println("Response Status Code    :" + httpResponse.getCode());
        System.out.println("Response Status Message :" + httpResponse.getReasonPhrase());
    }

    @Test(priority = 2)
    public void getMethodUsingApacheHttpClientFluentApproach2() throws IOException {

        Response response = Request.get("https://reqres.in/api/users/2").execute();
        System.out.println("Response Body :" + response.returnContent());
    }

    @Test(priority = 3)
    public void getMethodUsingApacheHttpClientFluentApproach3() throws IOException {

        Response response = Request.get("https://reqres.in/api/users/2").execute();
        APIResponse httpResponse = response.handleResponse(handler ->
                new APIResponse(EntityUtils.toString(handler.getEntity()), handler));
        System.out.println("Response Status Code    :" + httpResponse.responseContainer.getCode());
        System.out.println("Response Status Message :" + httpResponse.responseContainer.getReasonPhrase());
        System.out.println("Response Body :" + httpResponse.responseBody);
    }

    record APIResponse(String responseBody, ClassicHttpResponse responseContainer) {
    }

}

