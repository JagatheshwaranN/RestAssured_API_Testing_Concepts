package response.parser;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RegisterAndUnRegisterParserTestCase {

    @Test(priority = 1)
    public void registerAndUnRegisterParser(){

        RestAssured.registerParser("text/html", Parser.HTML);
        ValidatableResponse response =
                given()
                        .when()
                        .get("https://wttr.in/Location")
                        .then()
                        .using()
                        .defaultParser(Parser.JSON);

        System.out.println("Response : " +  response.extract().asPrettyString());
        RestAssured.unregisterParser("text/html");
    }

}
