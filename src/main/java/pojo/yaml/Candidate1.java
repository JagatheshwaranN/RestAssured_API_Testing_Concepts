
package pojo.yaml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "age",
    "hobbies",
    "firstname"
})

public class Candidate1 {

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("hobbies")
    private List<String> hobbies;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("hobbies")
    public List<String> getHobbies() {
        return hobbies;
    }

    @JsonProperty("hobbies")
    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @JsonProperty("firstname")
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty("firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Candidate1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("age");
        sb.append('=');
        sb.append(((this.age == null)?"<null>":this.age));
        sb.append(',');
        sb.append("hobbies");
        sb.append('=');
        sb.append(((this.hobbies == null)?"<null>":this.hobbies));
        sb.append(',');
        sb.append("firstname");
        sb.append('=');
        sb.append(((this.firstname == null)?"<null>":this.firstname));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
