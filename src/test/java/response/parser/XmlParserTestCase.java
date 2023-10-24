package response.parser;

import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class XmlParserTestCase {

    @Test(priority = 1)
    public void validateResponseByXmlParser() {

        ValidatableResponse response =
                given()
                .when()
                        .get("http://restapi.adequateshop.com/api/Traveler?page=1")
                .then()
                        .using()
                        .defaultParser(Parser.XML);

        System.out.println("Response : " + response.extract().asPrettyString());
    }

}
