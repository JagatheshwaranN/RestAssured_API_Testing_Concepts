package json_path.restassured;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class EvaluateJsonPathByGroovyFindTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathByGroovyExpression() {

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        List<Object> prices  = response.path("book.price");
        prices.forEach(System.out::println);
    }

    @Test(priority = 2)
    public void evaluateJsonPathByGroovyFindType1() {

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        Map<String, Object> book  = response.path("book.find{it.category=='fiction'}");
        book.entrySet().forEach(System.out::println);
    }

    @Test(priority = 3)
    public void evaluateJsonPathByGroovyFindType2() {

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        String author  = response.path("book.find{it.category=='reference'}.author");
        System.out.println(author);
    }

}