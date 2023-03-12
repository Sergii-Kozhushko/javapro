/**
 * HomeWork13.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 22-Feb-2023 20:47
 */

public class HomeWork13 {
   // 3.Дан массив чисел. Найти число состоящее из собственных делителей.
   // Например число 128 состоит из 1 2 и 8. 128 % 1 == 0 , 128 % 2 == 0 и 128 % 8 == 0. Вот такие числа надо найти.
   public static boolean isNumberFromDividers(int num){
      int tempNum = num, tryNum;
      while (tempNum > 0){
         tryNum = tempNum % 10;
         if (tryNum  == 0 || num % tryNum != 0) return false;
         tempNum = tempNum / 10;
      }
      return true;

   }
   public static void start(){
      int[] array = {128, 341, 10, 4, 33};
      System.out.print("Числа, состоящие из собственных делителей: ");
      for (int i = 0; i < array.length; i++){
         if (isNumberFromDividers(array[i]))
            System.out.print(array[i] + " ");
      }
   }

}
