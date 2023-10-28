package deserialization.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.Test;

public class ReadJsonStringAndConvertToJsonObjectTestCase {

    @Test(priority = 1)
    public void readJsonStringAndConvertToJsonObject() {

        String jsonString = """
                {
                   "john": {
                     "firstname": "John",
                     "lastname": "Doe",
                     "age": 30,
                     "skills": [
                       "Java",
                       "Python",
                       "JavaScript"
                     ],
                     "address": {
                       "street": "1234 Elm Street",
                       "city": "Any-town",
                       "state": "CA",
                       "zipcode": "12345"
                     }
                   }
                 }
                """;

        JsonObject jsonObject = getJsonObjectFromJson(jsonString);
        JsonObject baseNode = jsonObject.getAsJsonObject("john");
        String firstName = baseNode.get("firstname").getAsString();
        JsonArray skills = baseNode.getAsJsonArray("skills");
        String street = baseNode.getAsJsonObject("address").get("street").getAsString();
        System.out.println(firstName);
        System.out.println(skills);
        System.out.println(street);
    }

    private JsonObject getJsonObjectFromJson(String json) {
        return JsonParser.parseString(json).getAsJsonObject();
    }

}
