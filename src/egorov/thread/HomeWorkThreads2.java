/**
 * HomeWorkThreads.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-May-2023 19:52
 */

package egorov.thread;

/*Задача:
        Создайте 3 потока, которые вычисляют и выводят квадраты чисел от 1 до 10.
        Каждый поток должен использовать метод run() для вычисления и вывода квадратов.*/
public class HomeWorkThreads2 extends Thread {
   public static void main(String[] args) {
      for (int i = 1; i <= 3; i++) {
         var thread = new HomeWorkThreads2();
         thread.start();
      }
   }

   @Override
   public void run() {
      for (int j = 1; j <= 10; j++){
         System.out.println(Thread.currentThread().getName() + " : " + j + "^2 = " + (j * j));
      }
   }
}

