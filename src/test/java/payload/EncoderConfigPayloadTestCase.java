package payload;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class EncoderConfigPayloadTestCase {

    RequestSpecification requestSpecification;

    ResponseSpecification responseSpecification;

    @BeforeClass
    public void setRequestSpecificationUsingRequestSpecBuilder(){

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();

        requestSpecification = requestSpecBuilder
                .setBaseUri("https://b081e423-562e-43f3-9521-f956214a87d7.mock.pstmn.io/add")
                .addHeader("x-mock-match-request-body", "true")
                .setConfig(config.encoderConfig(EncoderConfig.encoderConfig()
                        .appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .setContentType(ContentType.JSON)
                .build();

        responseSpecBuilder = responseSpecBuilder
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        responseSpecification = responseSpecBuilder.build();
    }

    @Test(priority = 1)
    public void getSingleEmployeeUsingApproach1(){

        HashMap<String, Object> array1 = new HashMap<>();
        array1.put("name", "Jenni");

        HashMap<String, Object> array2 = new HashMap<>();
        array2.put("name", "Erick");

        List<HashMap<String, Object>> payloadList = new ArrayList<>();
        payloadList.add(array1);
        payloadList.add(array2);

        given()
                .spec(requestSpecification)
                .body(payloadList)
        .when()
                .post("/worker")
        .then()
                .spec(responseSpecification)
                .statusCode(201);
    }

}
