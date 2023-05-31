/**
 * Shop.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 30-May-2023 22:37
 */

package egorov.thread.triple;

public class Shop  implements  Runnable{
   Warehouses warehouses;

   public Shop(Warehouses warehouses) {
      this.warehouses = warehouses;
   }

   @Override
   public void run() {
      while (true){
         warehouses.sellProduct();
      }
   }
}
