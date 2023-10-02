package async;

import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncRequestTestCase {

    @Test(priority = 1)
    public void asyncRequest(){

        try {
        Future<Response> responseFuture =
                Dsl.asyncHttpClient()
                .prepareGet("https://reqres.in/api/users/2?delay=5")
                .execute();
            Response response = responseFuture.get();
            System.out.println(response.getStatusCode());
            System.out.println(response.getResponseBody());

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
