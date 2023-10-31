package yaml;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;
import pojo.yaml.Child;
import pojo.yaml.Employees;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class YamlBasicsTestCase {

    @Test(priority = 1)
    public void stringToMapByYamlType1() {
        Yaml yaml = new Yaml();
        String keyValue = "101: John";
        Map<Integer, String> map = yaml.load(keyValue);
        String valueFromMap = map.get(101);
        System.out.println(valueFromMap);
    }

    @Test(priority = 2)
    public void stringToMapByYamlType2() {
        Yaml yaml = new Yaml();
        String keyValue = "'101': John";
        Map<String, String> map = yaml.load(keyValue);
        String valueFromMap = map.get("101");
        System.out.println(valueFromMap);
    }

    @Test(priority = 3)
    public void multipleStringLinesToMapByYaml() {
        Yaml yaml = new Yaml();
        String keyValue = """
                name: John
                phone: 313-4455-345
                address: Jefferson Street, Texas""";

        Object object = yaml.load(keyValue);
        System.out.println("Object Type : " + object.getClass());

        if(object instanceof LinkedHashMap<?,?> map) {
            map.entrySet().forEach(System.out::println);
        }
    }

    @Test(priority = 4)
    public void yamlFileToMapByYaml(){
        Yaml yaml = new Yaml();
        String file = "src\\main\\java\\yaml\\user.yaml";
        Map<String, String> map;
        try {
            map = yaml.load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        map.entrySet().forEach(System.out::println);
    }

    @Test(priority = 5)
    public void yamlFileToPojoByYaml(){
        Yaml yaml = new Yaml();
        String file = "src\\main\\java\\yaml\\employees.yaml";
        Employees employees;
        try {
            employees = yaml.loadAs(new FileReader(file), Employees.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(employees);

        employees.getChild().forEach(System.out::println);

        for(Child child : employees.getChild()){
            System.out.println(child.getEmpId() + "="+ child.getEmpName());
        }
    }

}
