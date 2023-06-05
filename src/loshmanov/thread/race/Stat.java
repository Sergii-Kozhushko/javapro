/**
 * Photographer.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 05-Jun-2023 09:19
 */

package loshmanov.thread.race;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stat implements Runnable{
   private Car[] cars;
   private Thread thread;

   private final int UPDATE_FREQUENCY = 300;
   private long prevTime = 0;
   

   public Stat(Car[] cars) {
      this.cars = cars;
      thread = new Thread(this);
      thread.start();
   }

   public void printResults() {
      String resultString = "";
      for (int i = 0; i < cars.length; i++) {
         if (cars[i] != null && !cars[i].getState().isEmpty()) {
            resultString += cars[i].getName() + ":" + cars[i].getState();
            resultString +="|";
         }
      }
      DateFormat dfDateAndTime = new SimpleDateFormat("mm:ss.S");
      String currentTime = dfDateAndTime.format(new Date());
      //long currentTime = System.currentTimeMillis();
      System.out.printf("%s - %s%n", currentTime, resultString);
      //prevTime = currentTime;

   }

   public void printStartSpeed(){
      String resultString = "";
      for (int i = 0; i < cars.length; i++) {
         resultString += "Car" + cars[i].getName() + " " + cars[i].getSpeed() + " km/h |";
      }
      System.out.println(resultString);
   }

   public Thread getThread() {
      return thread;
   }

   @Override
   public void run() {
      printStartSpeed();
      while (!Thread.interrupted()){
         printResults();
         try {
            Thread.sleep(UPDATE_FREQUENCY);
            prevTime++;
         } catch (InterruptedException e) {
            return;
         }

      }

   }
}
