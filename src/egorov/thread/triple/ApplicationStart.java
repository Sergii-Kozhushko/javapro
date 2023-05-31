/**
 * ApplicationStart.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 30-May-2023 22:48
 */

package egorov.thread.triple;

public class ApplicationStart {
   public static void main(String[] args) {
      Warehouses warehouses = new Warehouses();
      Thread logisticThread = new Thread(new Logistic(warehouses));
      logisticThread.setName("Logistics");
      logisticThread.start();
      Thread factoryThread = new Thread(new Factory(warehouses));
      factoryThread.setName("Factory");
      factoryThread.start();
      Thread shopThread = new Thread(new Shop(warehouses));
      shopThread.setName("Shop");
      shopThread.start();

   }

}
