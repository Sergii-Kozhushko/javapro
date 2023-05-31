/**
 * Logistic.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 30-May-2023 22:26
 */

package egorov.thread.triple;

public class Logistic implements Runnable{
   Warehouses warehouses;

   public Logistic(Warehouses warehouses) {
      this.warehouses = warehouses;
   }

   @Override
   public void run() {
      while (true){
         warehouses.deliveryMaterialToFactory();
      }


   }
}
