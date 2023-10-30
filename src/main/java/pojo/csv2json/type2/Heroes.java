
package pojo.csv2json.type2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "squad_name",
    "home_town",
    "formed",
    "secret_base",
    "active",
    "members"
})

public class Heroes {

    @JsonProperty("squad_name")
    private String squadName;

    @JsonProperty("home_town")
    private String homeTown;

    @JsonProperty("formed")
    private Integer formed;

    @JsonProperty("secret_base")
    private String secretBase;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("members")
    private List<Member> members;

    @JsonProperty("squad_name")
    public String getSquadName() {
        return squadName;
    }

    @JsonProperty("squad_name")
    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    @JsonProperty("home_town")
    public String getHomeTown() {
        return homeTown;
    }

    @JsonProperty("home_town")
    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @JsonProperty("formed")
    public Integer getFormed() {
        return formed;
    }

    @JsonProperty("formed")
    public void setFormed(Integer formed) {
        this.formed = formed;
    }

    @JsonProperty("secret_base")
    public String getSecretBase() {
        return secretBase;
    }

    @JsonProperty("secret_base")
    public void setSecretBase(String secretBase) {
        this.secretBase = secretBase;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("members")
    public List<Member> getMembers() {
        return members;
    }

    @JsonProperty("members")
    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Heroes.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("squadName");
        sb.append('=');
        sb.append(((this.squadName == null)?"<null>":this.squadName));
        sb.append(',');
        sb.append("homeTown");
        sb.append('=');
        sb.append(((this.homeTown == null)?"<null>":this.homeTown));
        sb.append(',');
        sb.append("formed");
        sb.append('=');
        sb.append(((this.formed == null)?"<null>":this.formed));
        sb.append(',');
        sb.append("secretBase");
        sb.append('=');
        sb.append(((this.secretBase == null)?"<null>":this.secretBase));
        sb.append(',');
        sb.append("active");
        sb.append('=');
        sb.append(((this.active == null)?"<null>":this.active));
        sb.append(',');
        sb.append("members");
        sb.append('=');
        sb.append(((this.members == null)?"<null>":this.members));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
