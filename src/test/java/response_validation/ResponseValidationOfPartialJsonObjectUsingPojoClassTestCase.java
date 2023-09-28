package response_validation;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Employee;

import static io.restassured.RestAssured.given;

public class ResponseValidationOfPartialJsonObjectUsingPojoClassTestCase {

    @Test(priority = 1)
    public void responseValidationOfPartialJsonObjectUsingPojoClass(){

        Employee.Address response =
                given()
                .when()
                        .get("http://localhost:3000/employees/1")
                                .jsonPath().getObject("address", Employee.Address.class);

        Assert.assertEquals(response.getCity(), "New York");
        Assert.assertEquals(response.getState(), "New York");
        Assert.assertEquals(response.getZipcode(), "10001");
        Assert.assertEquals(response.getCountry(), "United States");

    }
}
