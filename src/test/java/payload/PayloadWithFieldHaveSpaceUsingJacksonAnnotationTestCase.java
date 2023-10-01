package payload;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.Book;

public class PayloadWithFieldHaveSpaceUsingJacksonAnnotationTestCase {

    @Test
    public void postUsingJsonWithFieldHaveSpaceUsingJacksonAnnotation() throws JsonProcessingException {

        Book book = new Book();
        book.setBookName("Java The Complete Reference");
        book.setBookAuthor("Herbert Schildt");

        ObjectMapper objectMapper = new ObjectMapper();
        String bookJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(book);
        System.out.println(bookJson);
    }

}
