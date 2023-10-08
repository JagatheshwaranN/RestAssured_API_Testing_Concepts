package serialization.jackson_annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.jackson.JacksonAnyGetter;

import java.util.HashMap;
import java.util.Map;

public class SerializationUsingJacksonAnyGetterTestCase {

    @Test(priority = 1)
    public void serializeUsingJacksonAnyGetter() throws JsonProcessingException {

        /*
          Without JacksonAnyGetter annotation usage, the result as below.
          {
            "employee" : {
              "address" : "USA",
              "phone" : "313-1234567",
              "name" : "David",
              "location" : "New Jersey",
              "id" : 1
            }
          }
         */

        JacksonAnyGetter jacksonAnyGetter = new JacksonAnyGetter();

        Map<String, Object> empMap = new HashMap<>();
        empMap.put("id", 1);
        empMap.put("name", "David");
        empMap.put("location", "New Jersey");
        empMap.put("phone", "313-1234567");
        empMap.put("address", "USA");

        jacksonAnyGetter.setEmployee(empMap);

        ObjectMapper objectMapper = new ObjectMapper();
        String serializedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jacksonAnyGetter);
        System.out.println(serializedJson);

    }
}
