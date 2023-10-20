package response.path;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EvaluateJsonPathByGroovyChainTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathByGroovyChaining() {

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        String title = response.path("book.findAll{it.category=='fiction'}.find{it.price > 20}.title");
        System.out.println(title);
    }

}