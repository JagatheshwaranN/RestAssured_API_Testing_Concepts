package response_validation.pojo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Employee;

import static io.restassured.RestAssured.given;

public class ResponseValidationOfPartialJsonObjectUsingPojoClassTestCase {

    @Test(priority = 1)
    public void responseValidationOfPartialJsonObjectUsingPojo(){

        Employee response =
                given()
                .when()
                        .get("http://localhost:3000/employees/1")
                                .jsonPath().getObject("address", Employee.class);

        Assert.assertEquals(response.getAddress().getCity(), "New York");
        Assert.assertEquals(response.getAddress().getState(), "New York");
        Assert.assertEquals(response.getAddress().getZipcode(), "10001");
        Assert.assertEquals(response.getAddress().getCountry(), "United States");

    }
}
