/**
 * Tunnel.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 04-Jun-2023 22:28
 */

package loshmanov.thread.race;


import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
   Semaphore semaphore = new Semaphore(2);
   public Tunnel() {
      this.length = 80;
      this.name = "Tunnel " + length + " m";
   }
   @Override
   public void go(Car c) {
      try {
         c.setState("waits: " + name);
         semaphore.acquire();
         c.setState("drives " + name);
         // поправка скорости от -3 до +3 на случайные события
         int speedSeed = (int)(Math.random()*(4) -3);
         Thread.sleep(length / (c.getSpeed() + speedSeed) * 1000L);
         c.setState("finished: " + name);
         semaphore.release();
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }

}
