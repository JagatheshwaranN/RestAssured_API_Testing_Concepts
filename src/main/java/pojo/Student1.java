package pojo;


import com.google.gson.annotations.Expose;

public class Student1 {

    @Expose(serialize = false)
    int id;

    @Expose()
    String name;

    @Expose()
    String location;
    @Expose()
    String phone;

    @Expose()
    String[] courses;

    public Student1(String name, String location, String phone, String[] courses) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String[] getCourses() {
        return courses;
    }

}
