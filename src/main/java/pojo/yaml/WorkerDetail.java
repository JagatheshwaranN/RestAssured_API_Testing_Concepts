
package pojo.yaml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "firstname",
    "lastname",
    "age",
    "rating",
    "marks",
    "birthday",
    "male",
    "favNum",
    "hobbies",
    "movies",
    "friends",
    "summary",
    "signature"
})
public class WorkerDetail {

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("marks")
    private Double marks;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("male")
    private Boolean male;

    @JsonProperty("favNum")
    private Double favNum;

    @JsonProperty("hobbies")
    private List<String> hobbies;

    @JsonProperty("movies")
    private List<String> movies;

    @JsonProperty("friends")
    private List<Friend> friends;

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("signature")
    private String signature;

    @JsonProperty("firstname")
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty("firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @JsonProperty("lastname")
    public String getLastname() {
        return lastname;
    }

    @JsonProperty("lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("rating")
    public String getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(String rating) {
        this.rating = rating;
    }

    @JsonProperty("marks")
    public Double getMarks() {
        return marks;
    }

    @JsonProperty("marks")
    public void setMarks(Double marks) {
        this.marks = marks;
    }

    @JsonProperty("birthday")
    public String getBirthday() {
        return birthday;
    }

    @JsonProperty("birthday")
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @JsonProperty("male")
    public Boolean getMale() {
        return male;
    }

    @JsonProperty("male")
    public void setMale(Boolean male) {
        this.male = male;
    }

    @JsonProperty("favNum")
    public Double getFavNum() {
        return favNum;
    }

    @JsonProperty("favNum")
    public void setFavNum(Double favNum) {
        this.favNum = favNum;
    }

    @JsonProperty("hobbies")
    public List<String> getHobbies() {
        return hobbies;
    }

    @JsonProperty("hobbies")
    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @JsonProperty("movies")
    public List<String> getMovies() {
        return movies;
    }

    @JsonProperty("movies")
    public void setMovies(List<String> movies) {
        this.movies = movies;
    }

    @JsonProperty("friends")
    public List<Friend> getFriends() {
        return friends;
    }

    @JsonProperty("friends")
    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("signature")
    public String getSignature() {
        return signature;
    }

    @JsonProperty("signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(WorkerDetail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("firstname");
        sb.append('=');
        sb.append(((this.firstname == null)?"<null>":this.firstname));
        sb.append(',');
        sb.append("lastname");
        sb.append('=');
        sb.append(((this.lastname == null)?"<null>":this.lastname));
        sb.append(',');
        sb.append("age");
        sb.append('=');
        sb.append(((this.age == null)?"<null>":this.age));
        sb.append(',');
        sb.append("rating");
        sb.append('=');
        sb.append(((this.rating == null)?"<null>":this.rating));
        sb.append(',');
        sb.append("marks");
        sb.append('=');
        sb.append(((this.marks == null)?"<null>":this.marks));
        sb.append(',');
        sb.append("birthday");
        sb.append('=');
        sb.append(((this.birthday == null)?"<null>":this.birthday));
        sb.append(',');
        sb.append("male");
        sb.append('=');
        sb.append(((this.male == null)?"<null>":this.male));
        sb.append(',');
        sb.append("favNum");
        sb.append('=');
        sb.append(((this.favNum == null)?"<null>":this.favNum));
        sb.append(',');
        sb.append("hobbies");
        sb.append('=');
        sb.append(((this.hobbies == null)?"<null>":this.hobbies));
        sb.append(',');
        sb.append("movies");
        sb.append('=');
        sb.append(((this.movies == null)?"<null>":this.movies));
        sb.append(',');
        sb.append("friends");
        sb.append('=');
        sb.append(((this.friends == null)?"<null>":this.friends));
        sb.append(',');
        sb.append("summary");
        sb.append('=');
        sb.append(((this.summary == null)?"<null>":this.summary));
        sb.append(',');
        sb.append("signature");
        sb.append('=');
        sb.append(((this.signature == null)?"<null>":this.signature));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
