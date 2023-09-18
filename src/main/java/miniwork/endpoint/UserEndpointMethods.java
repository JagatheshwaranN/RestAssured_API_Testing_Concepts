package miniwork.endpoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import miniwork.payload.User;
import static io.restassured.RestAssured.*;

public class UserEndpointMethods {

    public static Response createUser(User payload){

        return given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)
               .when()
                    .post(UserApiEndpoint.CREATE_USER);
    }

    public static Response retrieveUser(String userName){

        return given()
                    .contentType(ContentType.JSON)
                    .pathParam("user_name", userName)
               .when()
                    .get(UserApiEndpoint.RETRIEVE_USER);
    }

    public static Response updateUser(User payload, String userName){

        return given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)
                    .pathParam("user_name", userName)
               .when()
                    .put(UserApiEndpoint.UPDATE_USER);
    }

    public static Response deleteUser(String userName){

        return given()
                    .contentType(ContentType.JSON)
                    .pathParam("user_name", userName)
               .when()
                    .delete(UserApiEndpoint.DELETE_USER);
    }
}
