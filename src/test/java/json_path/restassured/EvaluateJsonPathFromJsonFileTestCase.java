package json_path.restassured;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class EvaluateJsonPathFromJsonFileTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathToTakeOnlyValuesFromArray() throws IOException {

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        List<Object> prices  = response.path("book.price");
        prices.forEach(System.out::println);
    }

    @Test(priority = 2)
    public void evaluateJsonPathToTakeKeyValuePairFromArray() throws IOException {

        Response response =
                given()
                        .when()
                        .get("http://localhost:3000/store");
        Map<String, Object> book  = response.path("book.find{it.category=='reference'}");
        book.entrySet().forEach(System.out::println);
    }




}