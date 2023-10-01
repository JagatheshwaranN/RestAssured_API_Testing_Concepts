package payload;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.Book1;

public class PayloadUsingLombokAndJacksonAnnotationTestCase {

    @Test
    public void postUsingLombokAndJacksonAnnotation() throws JsonProcessingException {

        Book1 book = Book1
                .builder()
                .bookName("Java The Complete Reference")
                .bookAuthor("Herbert Schildt")
                .bookPrice(700)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String bookJson1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(book);
        System.out.println(bookJson1);


        Book1 book2 = book
                .toBuilder()
                .bookName("Head First Java")
                .bookAuthor("Kathy Sierra and Bert Bates")
                .build();
        String bookJson2 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(book2);
        System.out.println(bookJson2);
    }

}
