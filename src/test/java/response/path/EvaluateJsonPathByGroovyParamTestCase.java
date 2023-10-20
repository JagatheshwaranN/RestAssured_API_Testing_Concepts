package response.path;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class EvaluateJsonPathByGroovyParamTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathByGroovyParam() {

        String category = "fiction";

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        List<String> title = response.path("book.findAll{it.category=='%s'}.title",category);
        title.forEach(System.out::println);
    }

}