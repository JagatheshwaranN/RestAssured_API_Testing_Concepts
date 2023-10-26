package scenarios;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.Product;

import java.io.File;
import java.io.IOException;

public class DynamicJsonHandleTestCase {

    String filePath;

    Product product;

    @Test(priority = 1)
    public void handleDynamicJson() throws IOException {
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

}
