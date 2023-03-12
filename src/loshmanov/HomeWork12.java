/**
 * HomeWork12.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 25-Feb-2023 23:45
 */

package loshmanov;

import java.util.Arrays;

// Дано целое число, представленное его разрядами, которые записаны в массив.
// апример, число 123 представляется массивом [1, 2, 3].
// Получите массив, который преставляет сумму исходного числа и 1.

public class HomeWork12 {
   public static int countDigits(int num){
      return (int) Math.ceil(Math.log10(num));
   }
   public static int[] convertNumberToArray(int num){
      int countDigits = countDigits(num);
      int[] result = new int[countDigits];
      int i = 0;
      while (num > 0){
         result[result.length-i-1] = num % 10;
         i++;
         num = num / 10;
      }
   return result;
   }
   public static int convertArrayToNumber(int[] array){
      int result = 0;
      for (int i = 0; i < array.length; i++) {
         result = result + array[i];
         result = result * 10;
      }
      return result / 10;
   }

   public static void main(String[] args) {

      int[] arrayInitial = {1, 2, 3, 9};
      int[] arrayFinal = convertNumberToArray(convertArrayToNumber(arrayInitial) + 1);
      System.out.println(Arrays.toString(arrayFinal));
   }
}
