package response.java_collection;

import static io.restassured.RestAssured.*;

import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ArrayResponseValidationTestCase {

    @Test(priority = 1)
    public void arrayResponseValidation() {

        ArrayList<String> books = new ArrayList<>();
        books.add("The Great Adventure");
        books.add("The Art of Cooking");
        books.add("Exploring the Cosmos");

        ValidatableResponse response =
        given()
        .when()
                .get("http://localhost:3000/store")
        .then()
                .statusCode(200);

        JSONObject jsonObject = new JSONObject(response.extract().asString());
        for(int i = 0; i < jsonObject.getJSONArray("books").length(); i++){
            System.out.println(jsonObject.getJSONArray("books").getJSONObject(i).get("title").toString());
            Assert.assertEquals(jsonObject.getJSONArray("books").getJSONObject(i).get("title").toString(), books.get(i));
        }
    }
}
