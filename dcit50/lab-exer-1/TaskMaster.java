/**
 * @author bricesuazo
 */

package TaskMaster;
import java.util.Scanner;

public class TaskMaster {
    public static void main(String args[]){
        Task task = new Task();
        
        Scanner in = new Scanner(System.in);
        System.out.print("Number of tasks: ");
        int noOfTask = in.nextInt();
        
        String db[][] = new String[noOfTask][5];
        
        setUpTask(task, noOfTask, db);
        displayTasks(task, noOfTask, db);
    }
    
    
    public static void setUpTask(Task task, int noOfTask, String db[][]){
        Scanner in = new Scanner(System.in);
        
        for(int i = 0; i < noOfTask; i++){
            System.out.print("Task " + (i + 1) + ": ");
            task.setName(in.next());
            db[i][0] = task.getName();
            
            System.out.print("Execution: ");
            task.setExecutionTime(in.nextInt());
            db[i][1] = String.valueOf(task.getStartTime());
            
            System.out.print("Deadline: ");
            task.setDeadline(in.nextInt());
            db[i][3] = String.valueOf(task.getDeadline());
            
            task.execute(task.getExecutionTime());
            db[i][2] = String.valueOf(task.getEndTime());
            db[i][4] = String.valueOf(task.delayed());
            System.out.println();
        }
    }
    
    public static void displayTasks(Task task, int noOfTask, String db[][]){
        System.out.println("Tasks\tStart\tEnd\tDeadline\tMissed");
        for(int i = 0; i < noOfTask; i++){
            while(true){
                int j = 0;
                System.out.print(db[i][j] + "\t");
                j++;
                System.out.print(db[i][j] + "\t");
                j++;
                System.out.print(db[i][j] + "\t");
                j++;
                System.out.print(db[i][j] + "\t\t");
                j++;
                String delayedText = Boolean.valueOf(db[i][j]) ? "Yes" : "No";
                System.out.println(delayedText);
                break;
            }
        }
    }
    
    
}
