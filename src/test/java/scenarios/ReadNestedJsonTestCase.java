package scenarios;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ReadNestedJsonTestCase {

    JsonNode jsonNode;

    @BeforeTest
    public void setup(){
        try {
            jsonNode = new ObjectMapper().readTree(new File("src/test/resources/users.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1)
    public void readSimpleJsonNode(){
       String baseNode =  "john";
       JsonNode node = jsonNode.get(baseNode);
       String firstName = node.get("firstname").asText();
       String age = node.get("age").asText();
       System.out.println("FirstName : " + firstName);
       System.out.println("Age       : " + age);
    }

    @Test(priority = 2)
    public void readNestedJsonNode(){
        String baseNode =  "john";
        String nestedNode = "address";
        JsonNode node = jsonNode.get(baseNode);
        JsonNode innerNode = node.get(nestedNode);
        String street = innerNode.get("street").asText();
        String city = innerNode.get("city").asText();
        System.out.println("Street : " + street);
        System.out.println("City   : " + city);
    }

    @Test(priority = 3)
    public void readNestedJsonArray(){
        String baseNode =  "john";
        String arrayNode = "skills";
        JsonNode node = jsonNode.get(baseNode);
        JsonNode innerNode = node.get(arrayNode);
        // To get single value from Array
        String skill1 = innerNode.get(1).asText();
        System.out.println("Skill 1 : " + skill1);
        // To get all the values from the Array
        ArrayNode skillsArrayNode = (ArrayNode) innerNode;
        if(skillsArrayNode.isArray()) {
            System.out.print("Skills : ");
            for(JsonNode value : skillsArrayNode){
                String valueText = value.asText();
                System.out.print(valueText + " ");
            }
        }
    }

}
