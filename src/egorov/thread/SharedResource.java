/**
 * SharedResource.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-May-2023 21:28
 */

package egorov.thread;

import lombok.val;

/*Создайте класс SharedResource, у которого есть
        целочисленное поле value. Создайте три потока,
        один из которых устанавливает значение value,
        а два других потока пытаются получить это значение.
        Используйте синхронизированный блок и метод wait()
        и notify() для синхронизации потоков.*/
public class SharedResource {
   private int value;

   public int getValue() {
      return value;
   }

   public void setValue(int value) {
      this.value = value;
   }

   public static void main(String[] args) {
      SharedResource sharedResource = new SharedResource();
      var waiter1 = new Thread(new ThreadGetter(sharedResource));
      waiter1.start();
      var waiter2 = new Thread(new ThreadGetter(sharedResource));
      waiter2.start();
      var notifier = new Thread(new ThreadPutter(sharedResource));
      notifier.start();
      System.out.println("All threads started!");

   }
}

// class puts some value to shared resource and calls notify()
class ThreadPutter implements Runnable {
   private SharedResource sharedResource;

   public ThreadPutter(SharedResource sharedResource) {
      this.sharedResource = sharedResource;
   }

   @Override
   public void run() {
      System.out.println(Thread.currentThread().getName() + " notifier started!");
      try {
         Thread.sleep(1000);
         synchronized (sharedResource) {
            sharedResource.setValue(5);
            System.out.println("Set value to shared resource and calls notifyAll()");
            sharedResource.notify();
            // если вызвать notifyAll, то проснутся оба потока
            //sharedResource.notifyAll();
         }
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
//  класс, вызывает wait()  и ждет сигнала от других потоков
class ThreadGetter implements Runnable {
   private SharedResource sharedResource;

   public ThreadGetter(SharedResource sharedResource) {
      this.sharedResource = sharedResource;
   }

   @Override
   public void run() {
      String threadName = Thread.currentThread().getName();
      synchronized (sharedResource) {
         System.out.println(threadName + " waits for notify at: " + System.currentTimeMillis());
         try {
            sharedResource.wait();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         System.out.println(Thread.currentThread().getName() + " received notify at: " + System.currentTimeMillis());
         System.out.println(threadName + " got value from shared resource: " + sharedResource.getValue());
      }

   }
}

