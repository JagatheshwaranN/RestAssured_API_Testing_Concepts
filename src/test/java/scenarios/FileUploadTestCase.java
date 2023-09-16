package scenarios;

import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @post
 */
public class FileUploadTestCase {

    @Test(priority = 1)
    public void fileUploadTestCase(){

        File file = new File("src//test//resources//Book.json");
        ValidatableResponse response =
        given()
                .multiPart("File", file)
                .contentType("multipart/form-data")
        .when()
                .post("https://postman-echo.com/post")
        .then()
                .statusCode(200);

        JSONObject jsonObject = new JSONObject(response.extract().asString());
        String fileDetail = jsonObject.getJSONObject("files").getString("Book.json");
        Assert.assertEquals(fileDetail, "data:application/octet-stream;base64,Ww0KIHsNCiAgICJCb29rSWQiOiAxLA0KICAgIkN1c3RvbWVyTmFtZSI6ICJKb2huIg0KIH0sDQogew0KICAgIkJvb2tJZCI6IDEsDQogICAiQ3VzdG9tZXJOYW1lIjogIkFsZXgiDQogfSwNCiB7DQogICAiQm9va0lkIjogMywNCiAgICJDdXN0b21lck5hbWUiOiAiRXJpY2siDQogfSwNCiB7DQogICAiQm9va0lkIjogNCwNCiAgICJDdXN0b21lck5hbWUiOiAiSmVubmkiDQogfSwNCiB7DQogICAiQm9va0lkIjogNiwNCiAgICJDdXN0b21lck5hbWUiOiAiQmxha2UiDQogfQ0KXQ==");
    }
}
