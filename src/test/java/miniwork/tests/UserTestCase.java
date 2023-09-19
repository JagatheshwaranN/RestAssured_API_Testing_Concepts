package miniwork.tests;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import miniwork.endpoint.UserApiEndpointMethods;
import miniwork.payload.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTestCase {

    Faker faker;
    User user;

    @BeforeClass
    public void dataSetup(){

        faker = new Faker();
        user = new User();
        user.setId(faker.idNumber().hashCode());
        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().safeEmailAddress());
        user.setPassword(faker.internet().password(5, 10));
        user.setPhone(faker.phoneNumber().cellPhone());
        user.setUserStatus(0);
    }

    @Test(priority = 1)
    public void validateCreateUserTest(){

        System.out.println("************ Create User Response ************");
        Response response = UserApiEndpointMethods.createUser(user);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(Integer.parseInt(response.jsonPath().get("message")), user.getId());
    }

    @Test(priority = 2)
    public void validateReadUserTest(){

        System.out.println("************ Read User Response ************");
        Response response = UserApiEndpointMethods.retrieveUser(user.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("username"), user.getUsername());
        Assert.assertEquals(response.jsonPath().get("firstName"), user.getFirstName());
        Assert.assertEquals(response.jsonPath().get("lastName"), user.getLastName());
        Assert.assertEquals(response.jsonPath().get("email"), user.getEmail());
        Assert.assertEquals(response.jsonPath().get("password"), user.getPassword());
        Assert.assertEquals((Integer) response.jsonPath().get("userStatus"), user.getUserStatus());
    }

    @Test(priority = 3)
    public void validateUpdateUserTest(){

        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().safeEmailAddress());
        System.out.println("************ Update User Response ************");
        Response response = UserApiEndpointMethods.updateUser(user, user.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(Integer.parseInt(response.jsonPath().get("message")), user.getId());
        validateReadUserTest();
    }

    @Test(priority = 4)
    public void validateDeleteUserTest(){

        System.out.println("************ Delete User Response ************");
        Response response = UserApiEndpointMethods.deleteUser(user.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("message"), user.getUsername());
    }
}
