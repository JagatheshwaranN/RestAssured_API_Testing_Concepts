package response.parser;

import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonParserTestCase {

    @Test(priority = 1)
    public void validateResponseByJsonParser(){

        ValidatableResponse response =
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .using()
                .defaultParser(Parser.JSON);

        System.out.println("Response : " +  response.extract().asPrettyString());
    }

}
