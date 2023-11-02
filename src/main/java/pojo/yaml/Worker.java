
package pojo.yaml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "worker"
})
public class Worker {

    @JsonProperty("worker")
    private WorkerDetail workerdetail;

    @JsonProperty("worker")
    public WorkerDetail getWorkerDetail() {
        return workerdetail;
    }

    @JsonProperty("worker")
    public void setWorkerDetail(WorkerDetail workerdetail) {
        this.workerdetail = workerdetail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Worker.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("worker");
        sb.append('=');
        sb.append(((this.workerdetail == null)?"<null>":this.workerdetail));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
