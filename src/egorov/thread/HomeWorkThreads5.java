/**
 * HomeWorkThreads5.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-May-2023 20:13
 */

package egorov.thread;

/*
Создайте 3 потока, каждый из которых выводит свое имя 5 раз.
        Каждый поток должен использовать метод run() для вывода имени.
*/
public class HomeWorkThreads5 {
   public static void main(String[] args) {
      new Thread(new ThreadName()).start();
      new Thread(new ThreadName()).start();
      new Thread(new ThreadName()).start();
   }

}
class ThreadName implements Runnable{

   @Override
   public void run() {
      for (int i = 1; i <= 5; i++) {
         System.out.println("My name is: " + Thread.currentThread().getName());
      }
   }
}
