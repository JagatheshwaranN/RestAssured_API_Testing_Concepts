package response.hamcrest.json;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ResponseValidationByHamcrestAssertionTestCase {

    @Test(priority = 1)
    public void validateResponseByHamcrestAssertThat() {

        String name =
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .extract()
                .response()
                .path("data.first_name");
        assertThat(name, equalTo( "Janet"));
    }

}
