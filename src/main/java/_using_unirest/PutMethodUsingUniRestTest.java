package _using_unirest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.Test;

public class PutMethodUsingUniRestTest {

    @Test(priority = 1)
    public void putMethodUsingUniRest() {

        try {
            String payloadJson = """ 
                                {
                                   "name":"John",
                                   "job":"Automation Tester"
                                  }
                                """;

            HttpResponse<JsonNode> response =
                    Unirest.put("https://reqres.in/api/users/2").body(payloadJson).asJson();
            int statusCode = response.getStatus();
            String statusMessage = response.getStatusText();
            String responseBody = String.valueOf(response.getBody());
            System.out.println("Response Status Code    :"+statusCode);
            System.out.println("Response Status Message :"+statusMessage);
            System.out.println("Response Body :"+responseBody);

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

}
