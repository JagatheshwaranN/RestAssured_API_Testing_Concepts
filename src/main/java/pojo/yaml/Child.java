
package pojo.yaml;

public class Child {

    private String empId;

    private String empName;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Child.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("empId");
        sb.append('=');
        sb.append(((this.empId == null)?"<null>":this.empId));
        sb.append(',');
        sb.append("empName");
        sb.append('=');
        sb.append(((this.empName == null)?"<null>":this.empName));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
