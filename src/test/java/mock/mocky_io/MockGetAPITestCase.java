package mock.mocky_io;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 * @mock
 */
public class MockGetAPITestCase {

    @Test(priority = 1)
    public void mockGetApiTest(){

        given()
                .log()
                .all()
        .when()
                .get("https://run.mocky.io/v3/7b474ce4-6d06-4255-a08d-38ba9544588a")
        .then()
                .statusCode(200)
                .log()
                .all();
    }

}
