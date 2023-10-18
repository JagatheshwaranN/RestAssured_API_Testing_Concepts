package json_path.restassured;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EvaluateJsonPathFromResponseByGroovyChainTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathByGroovyChainingToGetValueFromArray() {

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        String title = response.path("book.findAll{it.category=='fiction'}.find{it.price > 20}.title");
        System.out.println(title);
    }

}