package miniwork.tests;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import miniwork.endpoint.UserEndpointMethods;
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
        Response response = UserEndpointMethods.createUser(user);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(Integer.parseInt(response.jsonPath().get("message")), user.getId());
    }

    @Test(priority = 2)
    public void validateReadUserTest(){

        System.out.println("************ Read User Response ************");
        Response response = UserEndpointMethods.retrieveUser(user.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("username"), user.getUsername());
        Assert.assertEquals(response.jsonPath().get("firstName"), user.getFirstName());
    }

    @Test(priority = 3)
    public void validateUpdateUserTest(){

        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().safeEmailAddress());
        System.out.println("************ Update User Response ************");
        Response response = UserEndpointMethods.updateUser(user, user.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(Integer.parseInt(response.jsonPath().get("message")), user.getId());
        validateReadUserTest();
    }

    @Test(priority = 4)
    public void validateDeleteUserTest(){

        System.out.println("************ Delete User Response ************");
        Response response = UserEndpointMethods.deleteUser(user.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("message"), user.getUsername());
    }
}
