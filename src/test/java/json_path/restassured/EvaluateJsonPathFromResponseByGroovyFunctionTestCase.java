package json_path.restassured;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EvaluateJsonPathFromResponseByGroovyFunctionTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathByGroovyMaxToGetValueBasedOnConditionFromArray() {

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        String title = response.path("book.max{it.price}.title");
        System.out.println(title);
    }

    @Test(priority = 2)
    public void evaluateJsonPathByGroovyMinToGetValueBasedOnConditionFromArray() {

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/store");
        String title = response.path("book.min{it.price}.title");
        System.out.println(title);
    }

    @Test(priority = 3)
    public void evaluateJsonPathByGroovySumToGetCalculatedValueFromArray() {

        Response response =
                given()
                        .when()
                        .get("http://localhost:3000/store");
        /*
            Alternate way to perform sum() operation
            double price = response.path("book.findAll{it.price}.sum()");
        */
        double price = response.path("book.sum{it.price}");
        System.out.println(price);
    }

}