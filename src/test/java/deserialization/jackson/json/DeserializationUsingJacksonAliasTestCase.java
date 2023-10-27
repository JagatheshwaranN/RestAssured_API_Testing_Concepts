package deserialization.jackson.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.jackson.deserialize.json.JacksonAlias;

public class DeserializationUsingJacksonAliasTestCase {

    @Test(priority = 1)
    public void deserializeUsingJacksonAliasApproach1() throws JsonProcessingException {

        String sampleJson = """
                {
                   "empId" : 1,
                   "name" : "Ken",
                   "email" : "ken@test.com"
                 }""";

        ObjectMapper objectMapper = new ObjectMapper();
        JacksonAlias jacksonAlias = objectMapper.readValue(sampleJson, JacksonAlias.class);
        System.out.println(jacksonAlias.getId());
    }

    @Test(priority = 2)
    public void deserializeUsingJacksonAliasApproach2() throws JsonProcessingException {

        String sampleJson = """
                {
                   "empId" : 1,
                   "name" : "Ken",
                   "email" : "ken@test.com"
                 }""";

        JacksonAlias jacksonAlias = new ObjectMapper().readerFor(JacksonAlias.class).readValue(sampleJson);
        System.out.println(jacksonAlias.getId());
    }
}
