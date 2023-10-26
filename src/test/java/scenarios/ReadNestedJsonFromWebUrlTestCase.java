package scenarios;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class ReadNestedJsonFromWebUrlTestCase {

    JsonNode jsonNode;

    URL url;

    @BeforeTest
    public void setup(){
        try {
            url = URI.create("https://run.mocky.io/v3/930bd732-913d-482b-9f37-f3c22aa9f983").toURL();
            jsonNode = new ObjectMapper().readValue(url, JsonNode.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1)
    public void readJsonFromWebUrl(){
        String nodeName = "John";
        JsonNode node = jsonNode.get(nodeName);
        String firstName = node.get("firstname").asText();
        String age = node.get("age").asText();
        System.out.println("FirstName : " + firstName);
        System.out.println("Age       : " + age);
        String street = node.path("address").path("street").asText();
        System.out.println("Street    : " + street);
    }

}
