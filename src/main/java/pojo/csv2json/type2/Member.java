
package pojo.csv2json.type2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "age",
    "secret_identity",
    "powers"
})

public class Member {

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("secret_identity")
    private String secretIdentity;

    @JsonProperty("powers")
    private List<String> powers;

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

    @JsonProperty("secret_identity")
    public String getSecretIdentity() {
        return secretIdentity;
    }

    @JsonProperty("secret_identity")
    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    @JsonProperty("powers")
    public List<String> getPowers() {
        return powers;
    }

    @JsonProperty("powers")
    public void setPowers(List<String> powers) {
        this.powers = powers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Member.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("age");
        sb.append('=');
        sb.append(((this.age == null)?"<null>":this.age));
        sb.append(',');
        sb.append("secretIdentity");
        sb.append('=');
        sb.append(((this.secretIdentity == null)?"<null>":this.secretIdentity));
        sb.append(',');
        sb.append("powers");
        sb.append('=');
        sb.append(((this.powers == null)?"<null>":this.powers));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
