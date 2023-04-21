/**
 * Fibonacci.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 21-Apr-2023 11:56
 */

package egorov;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fibonacci {
   public static void main(String[] args) {
      int n = 10;// 0, 1, 2, 3, 4, 5, 6, 7
               //  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377,

      List<Integer> list = IntStream
              .rangeClosed(0, n-1)
              .boxed()
              .collect(Collectors.toList());

       System.out.println("Число Фибоначчи F(" + n +")=" +
               IntStream.rangeClosed(0, n - 1)//индексы
              .peek(x -> {
                  if (x > 1) {
                      list.set(x, list.get(x - 1) + list.get(x - 2));
                  }
              })
                      .map(x-> list.get(x)).
                       boxed().
                       collect(Collectors.toList()).
                       get(n-1)
               );


   }

}
