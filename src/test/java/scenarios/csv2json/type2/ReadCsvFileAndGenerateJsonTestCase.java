package scenarios.csv2json.type2;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.Test;
import pojo.csv2json.type2.Heroes;
import pojo.csv2json.type2.Member;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ReadCsvFileAndGenerateJsonTestCase {

    @Test(priority = 1)
    public void readCsvFileAndGenerateJson() throws IOException, CsvException {
        String csvFilePath = ".\\src\\test\\java\\scenarios\\csv2json\\type2\\heroes.csv";
        String file = ".\\src\\test\\java\\scenarios\\csv2json\\type2\\heroesFromCsv.json";
        LinkedHashMap<String, LinkedHashMap<String, String>> csvToLinkedHashMap = readCsvFile(new File(csvFilePath));
        Heroes heroesPojo = convertMapToPojo(csvToLinkedHashMap);
        FileWriter fileWriter;
        Gson gson = new Gson();
        try{
            fileWriter = new FileWriter(file);
            gson.toJson(heroesPojo, fileWriter);
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
        System.out.println(allCsvData.size());
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

    private Heroes convertMapToPojo(LinkedHashMap<String, LinkedHashMap<String, String>> csvToLinkedHashMap) {
        Heroes heroesPojo = new Heroes();
        List<Member> membersList = new ArrayList<>();
        LinkedHashMap<String, String> heroesData = csvToLinkedHashMap.get("1");
        heroesPojo.setSquadName(heroesData.get("squad_name"));
        heroesPojo.setHomeTown(heroesData.get("home_town"));
        heroesPojo.setFormed(Integer.parseInt(heroesData.get("formed")));
        heroesPojo.setSecretBase(heroesData.get("secret_base"));
        heroesPojo.setActive(Boolean.parseBoolean(heroesData.get("active")));
        for(Map.Entry<String, LinkedHashMap<String, String>> entry : csvToLinkedHashMap.entrySet()){
            LinkedHashMap<String, String> linkedHashMap = entry.getValue();
            Member memberPojo = new Member();
            memberPojo.setName(linkedHashMap.get("members_name"));
            memberPojo.setAge(Integer.parseInt(linkedHashMap.get("members_age")));
            memberPojo.setSecretIdentity(linkedHashMap.get("members_secret_identity"));
            List<String> powersList = Arrays.asList(linkedHashMap.get("members_powers").split(", "));
            memberPojo.setPowers(powersList);
            membersList.add(memberPojo);
        }
        heroesPojo.setMembers(membersList);
        return heroesPojo;
    }

}
