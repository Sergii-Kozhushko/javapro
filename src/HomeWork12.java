/**
 * HoWork12.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 22-Feb-2023 20:38
 */

public class HomeWork12 {

   // 2.Дан массив чисел, в котором есть все числа от 0 до N .
   // Все эти числа в единственном экземпляре. Расположены в разнобой.
   // Одно число в этом массиве пропущено ( Например {1 0 2 8 6 5 4 7} - это 3 ) . Найти пропущенное число
   public static void start(){
      int[] array = {1, 0, 2, 8, 6, 3, 4, 7};
      int sum1 = 0, sum2 = 0;
      for (int i = 0; i < array.length; i++){
         sum1 += array[i];
         sum2 += i + 1;
      }
      System.out.println("Пропущенное число: " + (sum2 - sum1));
   }

}
