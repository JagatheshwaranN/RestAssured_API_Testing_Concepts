package miniwork.endpoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import miniwork.payload.User;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserApiEndpointMethods {

    public static ResourceBundle bundle = ResourceBundle.getBundle("endpoint");
    public static String POST_URL;
    public static String GET_URL;
    public static String PUT_URL;
    public static String DELETE_URL;

    public static Response createUser(User payload, String runMode){

        if(runMode.equalsIgnoreCase("prop")){
            POST_URL = bundle.getString("create_user");
        }else{
            POST_URL = UserApiEndpoint.CREATE_USER;
        }
        return given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)
               .when()
                    .post(POST_URL);
    }

    public static Response retrieveUser(String userName, String runMode){

        if(runMode.equalsIgnoreCase("prop")){
            GET_URL = bundle.getString("retrieve_user");
        }else{
            GET_URL = UserApiEndpoint.RETRIEVE_USER;
        }
        return given()
                    .contentType(ContentType.JSON)
                    .pathParam("user_name", userName)
               .when()
                    .get(GET_URL);
    }

    public static Response updateUser(User payload, String userName, String runMode){

        if(runMode.equalsIgnoreCase("prop")){
            PUT_URL = bundle.getString("update_user");
        }else{
            PUT_URL = UserApiEndpoint.UPDATE_USER;
        }
        return given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)
                    .pathParam("user_name", userName)
               .when()
                    .put(PUT_URL);
    }

    public static Response deleteUser(String userName, String runMode){

        if(runMode.equalsIgnoreCase("prop")){
            DELETE_URL = bundle.getString("delete_user");
        }else{
            DELETE_URL = UserApiEndpoint.DELETE_USER;
        }
        return given()
                    .contentType(ContentType.JSON)
                    .pathParam("user_name", userName)
               .when()
                    .delete(DELETE_URL);
    }
}
