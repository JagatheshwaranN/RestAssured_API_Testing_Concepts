package scenarios;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.Product;
import pojo.ProductMap;

import java.io.File;
import java.io.IOException;

public class DynamicJsonHandleTestCase {

    String filePath;

    Product product;

    ProductMap productMap;

    @Test(priority = 1)
    public void handleDynamicJsonType1() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        filePath = "src/test/resources/shoe.json";
        product = readJson(filePath, mapper);
        System.out.println("===== Shoe Details =====");
        System.out.println("Product Name     : " + product.getName());
        System.out.println("Product Category : " + product.getCategory());
        System.out.println("Product Material : " + product.getDetails().get("material").asText());
        System.out.println("Product Color    : " + product.getDetails().get("color").asText());
        System.out.println("Product Size     : " + product.getDetails().get("size").asText());

        filePath = "src/test/resources/mobile.json";
        product = readJson(filePath, mapper);
        System.out.println("===== Mobile Details =====");
        System.out.println("Product Name     : " + product.getName());
        System.out.println("Product Category : " + product.getCategory());
        System.out.println("Product Display  : " + product.getDetails().get("display").asText());
        System.out.println("Product Color    : " + product.getDetails().get("color").asText());
        System.out.println("Product Storage  : " + product.getDetails().get("storage").asText());
    }

    private static Product readJson(String jsonFilePath, ObjectMapper mapper) throws IOException {
        return mapper.readValue(new File(jsonFilePath), Product.class);
    }

    @Test(priority = 2)
    public void handleDynamicJsonType2() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        filePath = "src/test/resources/shoe.json";
        productMap = readJsonType2(filePath, mapper);
        System.out.println("===== Shoe Details =====");
        System.out.println("Product Name     : " + productMap.getName());
        System.out.println("Product Category : " + productMap.getCategory());
        System.out.println("Product Material : " + productMap.getDetails().get("material"));
        System.out.println("Product Color    : " + productMap.getDetails().get("color"));
        System.out.println("Product Size     : " + productMap.getDetails().get("size"));

        filePath = "src/test/resources/mobile.json";
        productMap = readJsonType2(filePath, mapper);
        System.out.println("===== Mobile Details =====");
        System.out.println("Product Name     : " + productMap.getName());
        System.out.println("Product Category : " + productMap.getCategory());
        System.out.println("Product Display  : " + productMap.getDetails().get("display"));
        System.out.println("Product Color    : " + productMap.getDetails().get("color"));
        System.out.println("Product Storage  : " + productMap.getDetails().get("storage"));
    }

    private static ProductMap readJsonType2(String jsonFilePath, ObjectMapper mapper) throws IOException {
        return mapper.readValue(new File(jsonFilePath), ProductMap.class);
    }


}
