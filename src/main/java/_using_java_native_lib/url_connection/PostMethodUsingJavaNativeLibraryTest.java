package _using_java_native_lib.url_connection;

import org.testng.annotations.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class PostMethodUsingJavaNativeLibraryTest {

    @Test(priority = 1)
    public void postMethodUsingJavaNativeLibrary(){

        try {
            URL url = URI.create("https://reqres.in/api/users").toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            String payloadJson = """ 
                                {
                                   "name":"John",
                                   "job":"Tester"
                                  }
                                """;
            byte[] payload = payloadJson.getBytes();
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(payload);
            connection.connect();

            int statusCode = connection.getResponseCode();
            String statusMessage = connection.getResponseMessage();
            System.out.println("Response Status Code    :"+statusCode);
            System.out.println("Response Status Message :"+statusMessage);

            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String data;
            StringBuilder responseBody = new StringBuilder();
            while((data = bufferedReader.readLine()) != null){
                responseBody.append(data);
            }
            System.out.println("Response Body :"+responseBody);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
