package json_path.restassured;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class EvaluateJsonPathByGroovyFindFromResponseTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathByGroovyFindToGetOnlyValuesFromArray() {

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        List<Object> prices  = response.path("book.price");
        prices.forEach(System.out::println);
    }

    @Test(priority = 2)
    public void evaluateJsonPathByGroovyFindToGetFirstKeyValuePairBasedOnConditionFromArray() {

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        Map<String, Object> book  = response.path("book.find{it.category=='reference'}");
        book.entrySet().forEach(System.out::println);
    }

    @Test(priority = 3)
    public void evaluateJsonPathByGroovyFindToGetValueBasedOnConditionFromArray() {

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        String author  = response.path("book.find{it.category=='fiction'}.author");
        System.out.println(author);
    }

}