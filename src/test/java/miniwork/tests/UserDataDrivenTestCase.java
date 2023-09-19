package miniwork.tests;

import io.restassured.response.Response;
import miniwork.endpoint.UserApiEndpointMethods;
import miniwork.payload.User;
import miniwork.utils.DataSupplier;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserDataDrivenTestCase {

    @Test(priority = 1, dataProvider = "userdata", dataProviderClass = DataSupplier.class)
    public void validateCreateUserDataDrivenTest(String usrId, String usrNam, String fstNam, String lstNam, String mail, String pwd, String phNum){

        User user = new User();
        user.setId(Integer.parseInt(usrId));
        user.setUsername(usrNam);
        user.setFirstName(fstNam);
        user.setLastName(lstNam);
        user.setEmail(mail);
        user.setPassword(pwd);
        user.setPhone(phNum);
        user.setUserStatus(0);
        System.out.println("************ Create User Response ************");
        Response response = UserApiEndpointMethods.createUser(user);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2, dataProvider = "username", dataProviderClass = DataSupplier.class)
    public void validateDeleteUserDataDrivenTest(String usrNam){

        System.out.println("************ Delete User Response ************");
        Response response = UserApiEndpointMethods.deleteUser(usrNam);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
