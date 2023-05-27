/**
 * HomeWorkThreads4.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-May-2023 20:08
 */

package egorov.thread;

/*
Создайте 4 потока, которые выводят сообщение "Hello, World!"
        каждый с задержкой в 1 секунду. Каждый поток должен
        использовать метод run() для вывода сообщения.
*/
public class HomeWorkThreads4 {
   public static void main(String[] args) {
      for (int i = 1; i <=4 ; i++) {
         new Thread3().start();
      }
   }

}
class Thread3 extends Thread{
   @Override
   public void run() {

      try {
         sleep(1000);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
      System.out.println(this.getName() + " Hello world!");

   }
}
