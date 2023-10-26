package serialization.gson;

import com.google.gson.Gson;
import org.testng.annotations.Test;
import pojo.Address;
import pojo.Employee;

public class ConvertObjectToJsonUsingGsonTestCase {

    @Test(priority = 1)
    public void convertObjectToJsonByGson(){

        Employee employee = new Employee();
        Address address = new Address();

        address.setCity("Dallas");
        address.setState("Texas");
        address.setZipcode("75051");
        address.setCountry("USA");

        employee.setId(1);
        employee.setName("John");
        employee.setLocation("Reunion Tower");
        employee.setPhone("3134457859");
        employee.setAddress(address);

        Gson gson = new Gson();
        String employeeJson = gson.toJson(employee);
        System.out.println(employeeJson);
    }

}
