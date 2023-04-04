/**
 * HomeWork3103.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 03-Apr-2023 18:52
 */

package loshmanov;

import java.util.Arrays;
import java.util.function.Predicate;

// Task1:
//Допустим, у нас есть коллекция состоящая из строк.
// Arrays.asList(«Highload», «High», «Load», «Highload»).
// Посчитайте, сколько раз объект «High» встречается в коллекции. Используйте Stream API.
//
//Task2:
//Написать программу, которая проверяет, что строка начинается буквой “J”или “N” и
// заканчивается “A”. Используем функциональный интерфейс Predicate.
//
//
//Task3:
//Given an array nums containing n distinct numbers in the range [0, n],
// return the only number in the range that is missing from the array.
//Example 1:
//Input: nums = [3,0,1]
//Output: 2
//Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
//
//Example 2:
//Input: nums = [0,1]
//Output: 2
//Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
public class HomeWork3103 {
   public static void main(String[] args) {
      // Task1
      System.out.println("1. Количество слов 'High' в массиве: " + Arrays.asList("Highload", "High", "Load", "High High", "Highload").stream().
             filter(x->x.contains("High")).map(x->x.split(" ")).
              flatMap(Arrays::stream).count());

      // Task2
      Predicate<String> isFirstLetterJNLastA = x -> (x.charAt(0) == 'J' || x.charAt(0) == 'N')
              && x.charAt(x.length()-1) == 'A';
      String str = "Jane Air B";
      System.out.println("2. Строка '" + str + "' содержит первую J или N и последнюю A? " + isFirstLetterJNLastA.test(str));

      // Task 3
      int[] array = {0, 2, 3, 4, 5};
      System.out.println("3. Недостающий элемент массива " + Arrays.toString(array) + " : " +
              (array.length * (array.length + 1)/2 - Arrays.stream(array).sum()));

   }

}
