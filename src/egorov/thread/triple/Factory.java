/**
 * Factory.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 30-May-2023 22:33
 */

package egorov.thread.triple;

public class Factory implements Runnable{
   Warehouses warehouses;

   public Factory(Warehouses warehouses) {
      this.warehouses = warehouses;
   }

   @Override
   public void run() {
      while (true){
         warehouses.produceGood();
      }

   }
}

