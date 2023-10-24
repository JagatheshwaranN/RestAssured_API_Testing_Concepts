package response.parser;

import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HtmlParserTestCase {

    @Test(priority = 1)
    public void validateResponseByHtmlParser(){

        ValidatableResponse response =
                given()
                .when()
                        .get("https://static-rsa.badssl.com/")
                .then()
                        .using()
                        .defaultParser(Parser.HTML);

        System.out.println("Response : " +  response.extract().asPrettyString());
    }

}
