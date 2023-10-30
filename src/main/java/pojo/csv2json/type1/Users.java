
package pojo.csv2json.type1;

import java.util.List;

public class Users {

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Users.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("employees");
        sb.append('=');
        sb.append(((this.employees == null)?"<null>":this.employees));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
