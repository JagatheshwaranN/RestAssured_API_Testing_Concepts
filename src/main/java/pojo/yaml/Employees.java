
package pojo.yaml;

import java.util.List;

public class Employees {

    private List<Child> child;

    public List<Child> getChild() {
        return child;
    }

    public void setChild(List<Child> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Employees.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("child");
        sb.append('=');
        sb.append(((this.child == null)?"<null>":this.child));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
