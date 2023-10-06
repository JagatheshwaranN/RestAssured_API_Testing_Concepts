package response_validation.json_path;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import pojo.Employee1;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class ResponseExtractUsingRestAssuredJsonPathTestCase {

    @Test(priority = 1)
    public void responseExtractUsingRestAssuredJsonPath() {

        String response =
                given()
                .when()
                        .get("http://localhost:3000/employees/1")
                        .asPrettyString();

        // We can even not choose to give $ and keep it as empty string.
        // In case of empty string also, it will provide the same result.
        Employee1 emp1 = JsonPath.from(response).getObject("$", Employee1.class);
        System.out.println(emp1.getId());
        System.out.println(emp1.getName());
        System.out.println(emp1.getLocation());
        System.out.println(emp1.getPhone());
        System.out.println(emp1.getAddress());
    }

}
