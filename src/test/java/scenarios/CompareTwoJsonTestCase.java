package scenarios;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class CompareTwoJsonTestCase {

    @Test(priority = 1)
    public void compareTwoJson() throws JsonProcessingException {

        String firstJson = """
                {
                   "empId" : 1,
                   "name" : "Ken",
                   "email" : "ken@test.com"
                 }""";

        String secondJson = """
                {
                   "name" : "Ken",
                   "empId" : 1,
                   "email" : "ken@test.com"
                 }""";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode firstJsonNode = objectMapper.readTree(firstJson);
        JsonNode secondJsonNode = objectMapper.readTree(secondJson);
        System.out.println(firstJsonNode.equals(secondJsonNode));
    }
}
