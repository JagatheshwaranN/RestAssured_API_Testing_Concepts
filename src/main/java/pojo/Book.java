package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    @JsonProperty("book name")
    private String bookName;

    @JsonProperty("book author")
    private String bookAuthor;

}
