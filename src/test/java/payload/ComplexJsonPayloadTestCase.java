package payload;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.*;

public class ComplexJsonPayloadTestCase {

    /**
     * @restapi
     * @post
     * @dummy
     */
    @Test(priority = 1)
    public void complexJsonPayloadTest(){

        List<Map<String, Object>> complexJson = new ArrayList<>();

        Map<String, Object> firstObject = new HashMap<>();
        firstObject.put("id", 101);
        firstObject.put("name", "John");
        firstObject.put("email", "john@test.com");
        List<String> mobileNos = Arrays.asList("1234567890", "9876543210");
        firstObject.put("mobile", mobileNos);
        Map<String, Object> skills = new HashMap<>();
        skills.put("name", "Testing");
        skills.put("proficiency", "Master");
        firstObject.put("skills", skills);
        complexJson.add(firstObject);

        Map<String, Object> secondObject = new HashMap<>();
        secondObject.put("id", 102);
        secondObject.put("name", "Alex");
        secondObject.put("email", "alex@test.com");
        List<Map<String, Object>> skillList = new ArrayList<>();
        Map<String, Object> skill1 = new HashMap<>();
        skill1.put("name", "Selenium");
        skill1.put("proficiency", "Master");
        skillList.add(skill1);
        Map<String, Object> skill2 = new HashMap<>();
        skill2.put("name", "Java");
        skill2.put("proficiency", "Competent");
        List<String> certifications = Arrays.asList("OCJP 11", "OCJP 12");
        skill2.put("certification", certifications);
        skillList.add(skill2);
        secondObject.put("skills", skillList);
        complexJson.add(secondObject);

        RestAssured.baseURI = "https://www.example.com/";
        RestAssured.given().log().all().body(complexJson).post();
    }

}
