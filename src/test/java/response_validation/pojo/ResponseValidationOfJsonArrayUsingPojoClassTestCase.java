package response_validation.pojo;

import io.restassured.common.mapper.TypeRef;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Address;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ResponseValidationOfJsonArrayUsingPojoClassTestCase {

    @Test(priority = 1)
    public void responseValidationOfJsonArrayUsingPojo(){

        Address[] response =
                given()
                .when()
                        .get("http://localhost:3000/addresses")
                        .as(Address[].class);

        Assert.assertEquals(response[0].getCity(), "New York");
        Assert.assertEquals(response[0].getState(), "New York");
        Assert.assertEquals(response[0].getZipcode(), "10001");
        Assert.assertEquals(response[0].getCountry(), "United States");

    }

    @Test(priority = 2)
    public void responseValidationOfJsonArrayByListUsingPojo(){

        List<Address> response =
                given()
                        .when()
                        .get("http://localhost:3000/addresses")
                        .as(new TypeRef<List<Address>>(){});

        Assert.assertEquals(response.get(0).getCity(), "New York");
        Assert.assertEquals(response.get(0).getState(), "New York");
        Assert.assertEquals(response.get(0).getZipcode(), "10001");
        Assert.assertEquals(response.get(0).getCountry(), "United States");

    }
}
