package _using_apache_httpclient.fluent;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteMethodUsingApacheHttpClientTest {

    @Test(priority = 1)
    public void deleteMethodUsingApacheHttpClientFluent() throws IOException {

        Response response = Request.delete("https://reqres.in/api/users/2").execute();
        ClassicHttpResponse httpResponse = (ClassicHttpResponse) response.returnResponse();
        System.out.println("Response Status Code    :" + httpResponse.getCode());
        System.out.println("Response Status Message :" + httpResponse.getReasonPhrase());
    }

}
