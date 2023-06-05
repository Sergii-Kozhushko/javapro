/**
 * Stage.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 04-Jun-2023 22:28
 */

package loshmanov.thread.race;

public abstract class Stage {
   protected int length;
   protected String name;

   public void go(Car c) {
      try {
         c.setState("drives: " + name);
         // поправка скорости от -3 до +3 на случайные события
         int speedSeed = (int)(Math.random()*(4) -3);
         Thread.sleep(length / (c.getSpeed() + speedSeed) * 1000L);
         c.setState("finished: " + name);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }

   public String getName() {
      return name;
   }

}
