package parameters;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class MultiPartParameterTestCase {

    @Test
    public void multiPartFormDataParam(){

        String attributes = """
                {
                  "name": "book.json",
                  "folder": {
                    "id": 12345
                  }
                }""";
        given()
                .multiPart("file", new File("src/test/resources/Book.json"))
                .multiPart("attributes", attributes, "application/json")
        .when()
                .post("https://postman-echo.com/post")
        .then()
                .statusCode(200)
                .log()
                .status();
    }

}
