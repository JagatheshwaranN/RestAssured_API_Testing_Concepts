package _ip;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RestAssuredIPPractice1Test {

    /**
     * A. Basic Questions
     * ==================
     * What is RestAssured?
     * <p>
     * How do you set up RestAssured in a Maven project?
     * <p>
     * How do you send a GET request using RestAssured?
     * <p>
     * How do you validate the status code in RestAssured?
     * <p>
     * How do you send a POST request with a JSON body?
     * <p>
     * How do you extract a value from a JSON response?
     * <p>
     * How do you handle authentication in RestAssured?
     * <p>
     * How do you validate the response schema?
     * <p>
     * How do you log requests and responses in RestAssured?
     * <p>
     * How do you handle query parameters and path parameters?
     */

    @Test(priority = 1)
    public void restAssuredDef() {
        System.out.println("Rest Assured is a java library for testing the RESTFul web services.");
    }

    @Test(priority = 2)
    public void restAssuredSetup() {
        System.out.println("Rest Assured can be setup in Maven project via POM file. We have " +
                "to add the Rest Assured dependency in pom.xml file");
    }

    @Test(priority = 3)
    public void restAssuredGet() {
        // Approach 1
        Response response = RestAssured.get("https://api.example.com/users/1");
        System.out.println(response.getBody().asPrettyString());

        // Approach 2
        Response response1 = RestAssured.given()
                .baseUri("https://api.example.com/")
                .when()
                .basePath("users/1")
                .get();
        System.out.println(response1.getBody().asPrettyString());
    }

    @Test(priority = 4)
    public void restAssuredStatusCode() {
        // Approach 1
        Response response = RestAssured.get("https://api.example.com/users/1");
        System.out.println(response.getStatusCode());

        // Approach 2
        Response response1 = RestAssured.given()
                .baseUri("https://api.example.com/")
                .when()
                .basePath("users/1")
                .get();
        System.out.println(response1.getStatusCode());

        // Approach 3
        RestAssured.given()
                .baseUri("https://api.example.com/")
                .when()
                .basePath("users/1")
                .get()
                .then()
                .statusCode(200);

    }

    @Test(priority = 5)
    public void restAssuredPost() {
        String payload = """
                {\s
                    "name": "John",
                    "age": 30
                }
               \s""";

        // Approach 1
        Response response = RestAssured.given().contentType(ContentType.JSON).body(payload).post("https://api.example.com/users");
        System.out.println(response.getStatusCode());

        // Approach 2
        RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri("https://api.example.com")
                .body(payload)
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }

    @Test(priority = 6)
    public void restAssuredExtractJsonValue() {
        String payload = """
                {\s
                    "name": "John",
                    "age": 30
                }
               \s""";

        // Approach 1
        Response response = RestAssured.given().contentType(ContentType.JSON).body(payload).post("https://api.example.com/users");
        System.out.println(response.jsonPath().getString("name"));

        // Approach 2
        RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri("https://api.example.com")
                .body(payload)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body(Matchers.hasProperty("name"))
                .body(Matchers.contains("John"));
    }

    @Test(priority = 7)
    public void restAssuredAuth() {
        // Approach 1
        Response response = RestAssured.given().auth().basic("username", "password").get("https://api.example.com/users/1");
        System.out.println(response.getBody().asPrettyString());

        // Approach 2
        RestAssured.given()
                .auth()
                .oauth2("token")
                .contentType(ContentType.JSON)
                .baseUri("https://api.example.com")
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body(Matchers.hasProperty("name"))
                .body(Matchers.contains("John"));
    }

    @Test(priority = 8)
    public void restAssuredJsonSchema() {
        RestAssured.given()
                .baseUri("https://api.example.com")
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
    }

    @Test(priority = 9)
    public void restAssuredLogRequestResponse() {
        RestAssured.given()
                .baseUri("https://api.example.com")
                .log()
                .all()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test(priority = 10)
    public void restAssuredParams() {

        // Query Param
        RestAssured.given()
                .baseUri("https://api.example.com")
                .queryParam("page", 2)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log()
                .body();

        // Path Param
        RestAssured.given()
                .baseUri("https://api.example.com")
                .pathParam("id", 2)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(200)
                .log()
                .body();
    }

}
