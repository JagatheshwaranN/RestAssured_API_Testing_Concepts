package _using_java_native_lib.url_connection;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class DeleteMethodUsingJavaNativeLibraryTest {

    @Test(priority = 1)
    public void deleteMethodUsingJavaNativeLibrary() {

        try {
            URL url = URI.create("https://reqres.in/api/users/2").toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.connect();

            int statusCode = connection.getResponseCode();
            String statusMessage = connection.getResponseMessage();
            System.out.println("Response Status Code    :"+statusCode);
            System.out.println("Response Status Message :"+statusMessage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
