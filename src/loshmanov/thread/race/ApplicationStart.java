/**
 * ApplicationStart.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 04-Jun-2023 22:29
 */

package loshmanov.thread.race;

import java.util.concurrent.CyclicBarrier;

public class ApplicationStart {
   public static final int CARS_COUNT = 4;

   public static void main(String[] args) {

      CyclicBarrier startPoint = new CyclicBarrier(CARS_COUNT);
      Race race = new Race(new Road(60), new Tunnel(), new Road(40));
      Car[] cars = new Car[CARS_COUNT];
      for (int i = 0; i < cars.length; i++) {
         cars[i] = new Car(race, 20 + (int)(Math.random() * 10), startPoint);
      }
      // стат - отображает текущее состояние гонки
      Stat stat = new Stat(cars);

      Thread[] carsThreads = new Thread[CARS_COUNT];
      for (int i = 0; i < carsThreads.length; i++) {
         carsThreads[i] = new Thread(cars[i]);
         carsThreads[i].start();
      }
      // ждем, чтобы все машины приехали к финишу
      for (int i = 0; i < cars.length; i++) {
         try {
            carsThreads[i].join();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }

      System.out.println("Race is finished!");
      stat.printResults();
      stat.getThread().interrupt();
   }

}
