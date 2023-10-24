package response.parser;

import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TextParserTestCase {

    @Test(priority = 1)
    public void validateResponseByTextParser(){

        ValidatableResponse response =
                given()
                .when()
                        .get("https://baconipsum.com/api/?type=all-meat&paras=2&start-with-lorem=1")
                .then()
                        .using()
                        .defaultParser(Parser.TEXT);

        System.out.println("Response : " +  response.extract().asPrettyString());
    }
}
