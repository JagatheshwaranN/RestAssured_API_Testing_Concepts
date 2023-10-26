package scenarios;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class ConvertFileToURIToURLReadJsonTestCase {

    @Test(priority = 1)
    public void convertFileToUriToUrlAndReadJson() throws IOException {

        File file = new File("src/test/resources/users.json");
        URI uri = file.toURI();
        URL url = uri.toURL();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readValue(url, JsonNode.class);

        JsonNode node = jsonNode.get("john");
        String firstName = node.get("firstname").asText();
        String age = node.get("age").asText();
        System.out.println("FirstName : " + firstName);
        System.out.println("Age       : " + age);
        String street = node.path("address").path("street").asText();
        System.out.println("Street    : " + street);
    }
}
