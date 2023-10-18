package json_path.restassured;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class EvaluateJsonPathFromResponseByGroovyFindAllTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathByGroovyFindAllToGetValuesOnlyBasedOnConditionFromArray() {

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        List<Object> prices = response.path("book.findAll{it.category=='fiction'}.price");
        prices.forEach(System.out::println);
    }

    @Test(priority = 2)
    public void evaluateJsonPathByGroovyFindAllToGetKeyValuesPairsBasedOnConditionFromArray() {

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        List<Map<String, Object>> books = response.path("book.findAll{it.category=='fiction'}");
        books.forEach(System.out::println);
    }

}