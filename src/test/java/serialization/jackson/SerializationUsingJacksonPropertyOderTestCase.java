package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.jackson.serialize.JacksonPropertyOrder;

public class SerializationUsingJacksonPropertyOderTestCase {

    @Test(priority = 1)
    public void serializeUsingJacksonPropertyOrder() throws JsonProcessingException {
        /*
          Without JacksonPropertyOrder annotation usage, the result as below as per the POJO class variable declaration.
          {
            "name" : "Ken",
            "id" : 1,
            "email" : "ken@test.com"
          }
        */

        /*
          Using JacksonPropertyOrder annotation with Alphabetic Keyword, the result as below.
          {
            "email" : "ken@test.com",
            "id" : 1,
            "name" : "Ken"
          }
        */

        JacksonPropertyOrder jacksonPropertyOrder = new JacksonPropertyOrder();
        jacksonPropertyOrder.setId(1);
        jacksonPropertyOrder.setName("Ken");
        jacksonPropertyOrder.setEmail("ken@test.com");

        ObjectMapper objectMapper = new ObjectMapper();
        String serializedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jacksonPropertyOrder);
        System.out.println(serializedJson);
    }

}
