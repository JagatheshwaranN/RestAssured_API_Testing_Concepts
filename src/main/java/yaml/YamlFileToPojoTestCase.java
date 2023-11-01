package yaml;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;
import pojo.yaml.Child;
import pojo.yaml.Employees;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class YamlFileToPojoTestCase {

    @Test(priority = 1)
    public void yamlFileToPojoByYaml() {
        Yaml yaml = new Yaml();
        String file = "src\\main\\java\\yaml\\files\\employees.yaml";
        Employees employees;
        try {
            employees = yaml.loadAs(new FileReader(file), Employees.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(employees);

        employees.getChild().forEach(System.out::println);

        for (Child child : employees.getChild()) {
            System.out.println(child.getEmpId() + "=" + child.getEmpName());
        }
    }

}
