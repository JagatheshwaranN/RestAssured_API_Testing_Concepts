package pojo.jackson.deserialize;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JacksonCreatorAndProperty {

    public  int id;

    public  String name;

    public  String email;

    @JsonCreator
    public JacksonCreatorAndProperty(
            // @JsonSetter("empId")
            @JsonProperty("empId")
            int id,
            @JsonProperty("name")
            String name,
            @JsonProperty("email")
            String email){

        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
