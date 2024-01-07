package spec;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class RequestAndResponseSpecificationType2TestCase {

    RequestSpecBuilder requestSpecBuilder;

    ResponseSpecBuilder responseSpecBuilder;

    @BeforeMethod
    public void setup(){
        requestSpecBuilder = new RequestSpecBuilder();
        RestAssured.requestSpecification = requestSpecBuilder
                .setBaseUri("https://reqres.in/api")
                .setBasePath("/users/")
                .addHeader("Accept", "application/json")
                .build();

        responseSpecBuilder = new ResponseSpecBuilder();
        RestAssured.responseSpecification = responseSpecBuilder
                .expectStatusCode(200)
                .expectHeader("Content-Type", equalTo("application/json; charset=utf-8"))
                .log(LogDetail.BODY)
                .build();
    }

    @Test(priority = 1)
    public void getMethodUsingRequestAndResponseSpecificationApproach1(){
                get("2");
    }

    @Test(priority = 2)
    public void getMethodUsingRequestAndResponseSpecificationApproach2(){

        Response response =
                        get("2")
                .then()
                        .extract()
                        .response();
        assertThat(response.path("data.first_name").toString(), equalTo("Janet"));
    }

}
