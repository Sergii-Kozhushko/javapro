/**
 * Task.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 28-May-2023 00:13
 */

package egorov.thread.task;

public class Task {
   volatile private boolean finished = false;
   private boolean inProcess = false;
   private String name;

   public Task(String name) {
      this.name = name;
   }

   public boolean isFinished() {
      return finished;
   }

   public void setFinished(boolean finished) {
      this.finished = finished;
   }

   public boolean isInProcess() {
      return inProcess;
   }

   public void setInProcess(boolean inProcess) {
      this.inProcess = inProcess;
   }

   public void execute(){
      try {
         Thread.sleep(1000);
         //System.out.println("Doing some job");
         finished = true;
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   @Override
   public String toString() {
      return name;
   }
}
