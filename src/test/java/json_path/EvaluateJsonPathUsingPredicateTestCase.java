package json_path;

import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EvaluateJsonPathUsingPredicateTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathUsingInlinePredicate() throws IOException {

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

            List<Object> prices = JsonPath.parse(jsonFile).read("$.store.book[?(@.price < 10)].price");
            prices.forEach(System.out::println);
        }
    }

    @Test(priority = 2)
    public void evaluateJsonPathUsingInlinePredicateWithAndOption() throws IOException {

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

            List<Object> books = JsonPath.parse(jsonFile).read("$.store.book[?(@.price < 10 && @.category=='fiction')]");
            books.forEach(System.out::println);
        }
    }

    @Test(priority = 3)
    public void evaluateJsonPathUsingInlinePredicateWithOrOption() throws IOException {

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

            List<Object> books = JsonPath.parse(jsonFile).read("$.store.book[?(@.price > 10 || @.category=='reference')]");
            books.forEach(System.out::println);
        }
    }

    @Test(priority = 4)
    public void evaluateJsonPathUsingInlinePredicateWithNegation() throws IOException {

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

            List<Object> books = JsonPath.parse(jsonFile).read("$.store.book[?(!(@.price > 10 || @.category=='reference'))]");
            books.forEach(System.out::println);
        }
    }

}
