package scenarios.csv2json.type1;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.Test;
import pojo.csv2json.type1.Address;
import pojo.csv2json.type1.Employee;
import pojo.csv2json.type1.Users;

import java.io.*;
import java.util.*;

public class ReadCsvFileAndGenerateJsonTestCase {

    @Test(priority = 1)
    public void readCsvFileAndGenerateJson() throws IOException, CsvException {
        String csvFilePath = ".\\src\\test\\java\\scenarios\\csv2json\\users.csv";
        String file = ".\\src\\test\\java\\scenarios\\csv2json\\usersFromCsv.json";
        LinkedHashMap<String, LinkedHashMap<String, String>> csvToLinkedHashMap = readCsvFile(new File(csvFilePath));
        Users usersPojo = convertMapToPojo(csvToLinkedHashMap);
        FileWriter fileWriter;
        Gson gson = new Gson();
        try{
            fileWriter = new FileWriter(file);
            gson.toJson(usersPojo, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Json file successfully created");
    }

    public LinkedHashMap<String, LinkedHashMap<String, String>> readCsvFile(File file) throws IOException, CsvException {
        FileReader fileReader = new FileReader(file);
        CSVReader csvReader = new CSVReader(fileReader);
        List<String[]> allCsvData = csvReader.readAll();
        csvReader.close();
        LinkedHashMap<String, LinkedHashMap<String, String>> csvToLinkedHashMap = new LinkedHashMap<>();
        String[] headerArray = allCsvData.get(0);
        List<String> headerList = Arrays.asList(headerArray);
        for(int i = 1; i < allCsvData.size(); i++){
            List<String> dataRow = Arrays.asList(allCsvData.get(i));
            LinkedHashMap<String, String> csvDataObjectHashMap = new LinkedHashMap<>();
            for(int j = 0; j < headerList.size(); j++){
                csvDataObjectHashMap.put(headerList.get(j), dataRow.get(j));
            }
            csvToLinkedHashMap.put(dataRow.get(0), csvDataObjectHashMap);
        }
        return csvToLinkedHashMap;
    }

    private Users convertMapToPojo(LinkedHashMap<String, LinkedHashMap<String, String>> csvToLinkedHashMap) {
        Users usersPojo = new Users();
        List<Employee> employeeList = new ArrayList<>();
        for(LinkedHashMap<String, String> linkedHashMap : csvToLinkedHashMap.values()){
            Employee employee = new Employee();
            Address address = new Address();
            for(Map.Entry<String, String> entry : linkedHashMap.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                switch (key) {
                    case "firstname" -> employee.setFirstname(value);
                    case "lastname" -> employee.setLastname(value);
                    case "age" -> employee.setAge(Integer.valueOf(value));
                    case "skills" -> employee.setSkills(Collections.singletonList(value));
                    case "address_street" -> address.setStreet(value);
                    case "address_city" -> address.setCity(value);
                    case "address_state" -> address.setState(value);
                    case "address_zipcode" -> address.setZipcode(value);
                }
            }
            employee.setAddress(address);
            employeeList.add(employee);
        }
        usersPojo.setEmployees(employeeList);
        return usersPojo;
    }

}
