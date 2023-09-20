package miniwork.tests;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import miniwork.endpoint.UserApiEndpointMethods;
import miniwork.payload.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserTestCase {

    Faker faker;
    User user;

    private Logger log;

    @BeforeClass
    public void setup(){

        log = LogManager.getLogger(this.getClass());
        log.info("Test data setup is initiated");
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
        log.info("Test data setup is completed");
    }

    @Test(priority = 1)
    @Parameters({"runMode"})
    public void validateCreateUserTest(String runMode){

        log.info("************ Create User Response ************");
        Response response = UserApiEndpointMethods.createUser(user, runMode);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(Integer.parseInt(response.jsonPath().get("message")), user.getId());
        log.info("************ Create User Completed ************");
    }

    @Test(priority = 2)
    @Parameters({"runMode"})
    public void validateReadUserTest(String runMode){

        log.info("************ Read User Response ************");
        Response response = UserApiEndpointMethods.retrieveUser(user.getUsername(), runMode);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("username"), user.getUsername());
        Assert.assertEquals(response.jsonPath().get("firstName"), user.getFirstName());
        Assert.assertEquals(response.jsonPath().get("lastName"), user.getLastName());
        Assert.assertEquals(response.jsonPath().get("email"), user.getEmail());
        Assert.assertEquals(response.jsonPath().get("password"), user.getPassword());
        Assert.assertEquals((Integer) response.jsonPath().get("userStatus"), user.getUserStatus());
        log.info("************ Read User Completed ************");
    }

    @Test(priority = 3)
    @Parameters({"runMode"})
    public void validateUpdateUserTest(String runMode){

        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().safeEmailAddress());
        log.info("************ Update User Response ************");
        Response response = UserApiEndpointMethods.updateUser(user, user.getUsername(), runMode);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(Integer.parseInt(response.jsonPath().get("message")), user.getId());
        validateReadUserTest(runMode);
        log.info("************ Update User Completed ************");
    }

    @Test(priority = 4)
    @Parameters({"runMode"})
    public void validateDeleteUserTest(String runMode){

        log.info("************ Delete User Response ************");
        Response response = UserApiEndpointMethods.deleteUser(user.getUsername(), runMode);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("message"), user.getUsername());
        log.info("************ Delete User Completed ************");
    }
}
