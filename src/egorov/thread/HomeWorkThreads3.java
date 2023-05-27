/**
 * HomeWorkThreads3.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-May-2023 20:01
 */

package egorov.thread;

/*Создайте 2 потока, которые выводят все четные числа от 1 до 20
        и все нечетные числа от 1 до 20 соответственно.
        Каждый поток должен использовать метод run() для вывода чисел.*/
public class HomeWorkThreads3 {
   public static void main(String[] args) {
      new Thread1().start();
      new Thread2().start();
   }
}
class Thread1 extends Thread{
   @Override
   public void run() {
      for (int i = 1; i <= 20 ; i+=2) {
         System.out.println(this.getName() + " : " + i);
      }
   }
}
class Thread2 extends Thread{
   @Override
   public void run() {
      for (int i = 2; i <= 20 ; i+=2) {
         System.out.println(this.getName() + " : " + i);
      }
   }
}


