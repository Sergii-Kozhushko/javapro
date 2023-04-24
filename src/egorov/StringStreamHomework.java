/**
 * StringStreamHomework.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 24-Apr-2023 19:49
 */

package egorov;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringStreamHomework {
   /**
    * String text = "???";
    * И вывести на экран все уникальные слова и количество их повторений
    * отсортировать в порядке убывания.
    * Так же подсчитать количество всех слов
    * Ex:
    * mama - 2
    * is - 3
    * i - 3
    * throw - 1
    */
   public static void main(String[] args) {
      String str = "Mama mila ramu mila";
      Arrays.stream(str.split(" "))
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
              .entrySet().stream()
              .sorted(Comparator.comparingLong(Map.Entry::getValue))
              .forEach(x->System.out.println(x.getKey()+"-"+x.getValue()));
      System.out.println("Общее количество слов: " + Arrays.stream(str.split(" ")).count());
   }

}
