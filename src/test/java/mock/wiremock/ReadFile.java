package mock.wiremock;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        JSONObject emptyCartJson = new JSONObject(readJsonFile(System.getProperty("user.dir")+"/src/test/resources/__files/json/emptycart.json"));
        System.out.println(emptyCartJson);
    }

    private static String readJsonFile(String fileName) throws IOException {
        Path path = Path.of(fileName);
        return Files.readString(path, StandardCharsets.UTF_8);
    }


}
