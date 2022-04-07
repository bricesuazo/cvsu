/**
 * @author bricesuazo
 */

package TaskMaster;

public class Task {
    String name;
    int executionTime, deadline, startTime, endTime;
    
    void setName(String name){
        this.name = name;
    }
    String getName(){
        return this.name;
    }
    
    void setExecutionTime(int time) {
        this.executionTime = time;
    }
    int getExecutionTime() {
        return this.executionTime;
    }
    
    void setDeadline(int time) {
        this.deadline = time;
    }
    int getDeadline() {
        return this.deadline;
    }
    
    
    void execute(int time) {
        this.endTime = this.startTime + time;
        this.startTime = this.endTime;
    }
    
    int getStartTime(){
        return this.startTime;
    }
    
    int getEndTime() {
        return this.endTime;
    }
    boolean delayed(){
        return getEndTime() > getDeadline();
    }
}
