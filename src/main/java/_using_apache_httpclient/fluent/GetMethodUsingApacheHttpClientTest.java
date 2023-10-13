package _using_apache_httpclient.fluent;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetMethodUsingApacheHttpClientTest {

    @Test(priority = 1)
    public void getMethodUsingApacheHttpClientFluent() throws IOException {

        Response response = Request.get("https://reqres.in/api/users/2").execute();
        System.out.println(response.returnContent().asString());
    }

}

