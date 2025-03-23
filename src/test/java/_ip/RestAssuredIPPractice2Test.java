package _ip;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RestAssuredIPPractice2Test {


    /**
     * B. Advanced Questions
     * How do you perform data-driven testing in RestAssured?
     * <p>
     * How do you handle cookies in RestAssured?
     * <p>
     * How do you test file uploads using RestAssured?
     * <p>
     * How do you integrate RestAssured with TestNG or JUnit?
     * <p>
     * How do you handle SSL certificates in RestAssured?
     * <p>
     * How do you measure response time in RestAssured?
     * <p>
     * How do you use POJOs for serialization and deserialization?
     * <p>
     * How do you validate JSON response using RestAssured?
     * <p>
     * What is the use of ObjectMapper?
     * <p>
     * How to use request and response specifications?
     */

    @DataProvider
    public Object[][] getUserData() {
        return new Object[][]{
                {"John", 30},
                {"Jane", 25}
        };
    }

    @Test(priority = 1, dataProvider = "getUserData")
    public void restAssuredCreateUser(String name, int age) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("age", age);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri("https://api.example.com/users")
                .body(jsonObject.toString())
                .when()
                .post()
                .then()
                .statusCode(201)
                .log()
                .body();
    }

    @Test(priority = 2)
    public void restAssuredCookies() {
        ValidatableResponse response = RestAssured.given()
                .baseUri("https://api.example.com/login")
                .when()
                .get()
                .then()
                .statusCode(200);
        Cookie cookie = response.extract().detailedCookies().get("sessionIf");

        Response response1 = RestAssured.given()
                .cookie("sessionId", cookie)
                .get("https://api.example.com/secure");
        System.out.println(response1.getBody());
    }

    @Test(priority = 3)
    public void restAssuredFileUpload() {
        File file = new File("/src/test/resources/sample.txt");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .multiPart(file)
                .when()
                .post("https://api.example.com/upload");
        System.out.println(response.getStatusCode());
    }

    @Test(priority = 4)
    public void restAssuredSSLError() {
        RestAssured.useRelaxedHTTPSValidation();
        ValidatableResponse response = RestAssured.given()
                .baseUri("https://api.example.com/login")
                .when()
                .get()
                .then()
                .statusCode(200);
        System.out.println(response.extract().body());
    }

    @Test(priority = 5)
    public void restAssuredResTime() {
        Response response = RestAssured.given()
                .baseUri("https://api.example.com/login")
                .when()
                .get();
        System.out.println(response.time());
    }

    @Test(priority = 6)
    public void restAssuredPOJO() {

        class User {

            private String name;
            private int age;

            public User() {

            }

            public void setName(String name) {
                this.name = name;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }

        }

        // Serialization
        User user = new User();
        user.setName("John");
        user.setAge(30);
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri("https://api.example.com")
                .body(user)
                .when()
                .post("/users");
        System.out.println(response.getStatusCode());

        // Deserialization
        Response response1 = RestAssured.given()
                .get("https://api.example.com/users/1");
        User user1 = response1.as(User.class);
        System.out.println(user1.getName());
        System.out.println(user1.getAge());
    }

    @Test(priority = 7)
    public void restAssuredMatchers() {
        RestAssured.given()
                .baseUri("https://api.example.com/login")
                .when()
                .get()
                .then()
                .body("name", equalTo("John"));
    }

    @Test(priority = 8)
    public void restAssuredObjectMapper() {
        // User user = new User("John", 30);
        ObjectMapper objectMapper = new ObjectMapper();
        // String json = objectMapper.writeValueAsString(user);

        // User newUser = objectMapper.readValues(json, User.class);
        // System.out.println(newUser.getName());
    }

    @Test(priority = 9)
    public void restAssuredReqResSpec() {

        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri("https://api.example.com")
                .contentType(ContentType.JSON);

        ResponseSpecification responseSpecification = RestAssured.expect()
                .statusCode(200)
                .body("data.id", notNullValue());

        RestAssured.given()
                .spec(requestSpecification)
                .when()
                .get("/users")
                .then()
                .spec(responseSpecification);
    }

    @Test(priority = 9)
    public void restAssuredFilter() {
        RestAssured.given()
                .baseUri("https://api.example.com")
                .basePath("/users/1")
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .when()
                .get()
                .then()
                .statusCode(200);
    }

}
