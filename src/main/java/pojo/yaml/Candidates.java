
package pojo.yaml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "candidate1",
    "candidate2"
})

public class Candidates {

    @JsonProperty("candidate1")
    private Candidate1 candidate1;

    @JsonProperty("candidate2")
    private Candidate2 candidate2;

    @JsonProperty("candidate1")
    public Candidate1 getCandidate1() {
        return candidate1;
    }

    @JsonProperty("candidate1")
    public void setCandidate1(Candidate1 candidate1) {
        this.candidate1 = candidate1;
    }

    @JsonProperty("candidate2")
    public Candidate2 getCandidate2() {
        return candidate2;
    }

    @JsonProperty("candidate2")
    public void setCandidate2(Candidate2 candidate2) {
        this.candidate2 = candidate2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Candidates.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("candidate1");
        sb.append('=');
        sb.append(((this.candidate1 == null)?"<null>":this.candidate1));
        sb.append(',');
        sb.append("candidate2");
        sb.append('=');
        sb.append(((this.candidate2 == null)?"<null>":this.candidate2));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
