package pojo.jackson;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// @JsonPropertyOrder(alphabetic = true)
@JsonPropertyOrder({"id", "name", "email"})
public class JacksonPropertyOrder {

    private String name;

    private int id;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
