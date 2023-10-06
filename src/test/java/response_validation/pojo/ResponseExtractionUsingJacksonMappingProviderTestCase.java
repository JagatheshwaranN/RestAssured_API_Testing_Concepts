package response_validation.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
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
public class ResponseExtractionUsingJacksonMappingProviderTestCase {

    @Test(priority = 1)
    public void responseExtractUsingJacksonMappingProvider() throws JsonProcessingException {

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

        Employee1 emp1 = JsonPath.using(configuration).parse(response).read("$", Employee1.class);
        System.out.println(emp1.getId());
        System.out.println(emp1.getName());
        System.out.println(emp1.getLocation());
        System.out.println(emp1.getPhone());
        System.out.println(emp1.getAddress());
    }

}
