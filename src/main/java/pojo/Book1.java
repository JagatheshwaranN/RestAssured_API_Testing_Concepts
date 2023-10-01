package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class Book1 {

    @JsonProperty("book name")
    private String bookName;

    @JsonProperty("book author")
    private String bookAuthor;

    @JsonProperty("book price")
    private int bookPrice;

}
