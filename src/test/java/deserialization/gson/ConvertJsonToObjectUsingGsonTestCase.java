package deserialization.gson;

import com.google.gson.Gson;
import org.testng.annotations.Test;
import pojo.Employee;

public class ConvertJsonToObjectUsingGsonTestCase {

    @Test(priority = 1)
    public void convertJsonToObjectByGson(){

        String sampleJson = """
                {
                  "id": 1,
                  "name": "John",
                  "location": "Reunion Tower",
                  "phone": "3134457859",
                  "address": {
                    "city": "Dallas",
                    "state": "Texas",
                    "zipcode": "75051",
                    "country": "USA"
                  }
                }""";

        Employee employee = new Gson().fromJson(sampleJson, Employee.class);
        System.out.println("Employee Id      : " + employee.getId());
        System.out.println("Employee Name    : " + employee.getName());
        System.out.println("Employee Location: " + employee.getLocation());
        System.out.println("Employee Phone   : " + employee.getPhone());
        System.out.println("Employee City    : " + employee.getAddress().getCity());
        System.out.println("Employee State   : " + employee.getAddress().getState());
        System.out.println("Employee Zipcode : " + employee.getAddress().getZipcode());
        System.out.println("Employee Country : " + employee.getAddress().getCountry());
    }

}
