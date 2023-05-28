/**
 * TaskList.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 28-May-2023 19:48
 */

package egorov.thread;

import egorov.thread.task.Task;

import java.util.ArrayList;

public class TaskList {
   private ArrayList<Task> taskList = new ArrayList<>();

   public ArrayList<Task> getTaskList() {
      return taskList;
   }
   public Task getAnyUnfinishedTask(){
      return taskList.stream().filter(x -> !x.isFinished() && !x.isInProcess()).findFirst().orElse(null);
   }

   public long getUnfinishedNumber(){
      return taskList.stream().filter(x -> !x.isFinished()).count();
   }
   public String getStatistics(){
      return String.format("All tasks=%d, not finished=%d%n", taskList.size(), getUnfinishedNumber());
   }

   public int getSize(){
      return taskList.size();
   }

   public void executeTask(Task task){

      task.setInProcess(true);
      task.execute();
      task.setInProcess(false);
      task.setFinished(true);
   }
}
