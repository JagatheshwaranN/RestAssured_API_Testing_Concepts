package deserialization.gson;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ReadJsonFileAndConvertToJsonObjectTestCase {

    @Test(priority = 1)
    public void readJsonFileAndConvertToJsonObject() {

        Gson gson = new Gson();
        String jsonFile = "src/test/resources/users.json";
        JsonObject jsonObject = getJsonObjectFromJson(jsonFile, gson);
        JsonObject baseNode = jsonObject.getAsJsonObject("john");
        String firstName = baseNode.get("firstname").getAsString();
        JsonArray array = baseNode.getAsJsonArray("skills");
        String street = baseNode.getAsJsonObject("address").get("street").getAsString();
        System.out.println(firstName);
        System.out.println(array);
        System.out.println(street);
        // Get the Array Elements as List
        List<?> list = gson.fromJson(String.valueOf(array), ArrayList.class);
        System.out.println(list);
    }

    private JsonObject getJsonObjectFromJson(String file, Gson gson) {

        JsonElement jsonElement;
        JsonObject jsonObject;
        try (Reader reader = new FileReader(file)) {
            jsonElement = gson.fromJson(reader, JsonElement.class);
            // If needed, we can use below conversion.
            // String jsonString = gson.toJson(jsonElement);
            jsonObject = jsonElement.getAsJsonObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonObject;
    }

}
