package response.json_path.jayway;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.testng.annotations.Test;
import pojo.Employee1;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class ResponseExtractUsingJaywayJsonPathAndJacksonMappingProviderTestCase {

    @Test(priority = 1)
    public void responseExtractUsingJaywayJsonPathAndJacksonMappingProvider() {

        String response =
                given()
                .when()
                        .get("http://localhost:3000/employees/1")
                        .asPrettyString();

        JacksonMappingProvider jacksonMappingProvider = new JacksonMappingProvider();
        Configuration configuration =
                Configuration
                .builder()
                .mappingProvider(jacksonMappingProvider)
                .build();

        // We can even not choose to give $ and keep it as empty string.
        // In case of empty string also, it will provide the same result.
        Employee1 emp1 = JsonPath.using(configuration).parse(response).read("$", Employee1.class);
        System.out.println(emp1.getId());
        System.out.println(emp1.getName());
        System.out.println(emp1.getLocation());
        System.out.println(emp1.getPhone());
        System.out.println(emp1.getAddress());
    }

}
