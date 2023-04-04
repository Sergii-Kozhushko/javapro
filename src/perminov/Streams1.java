/**
 * Streams1.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 04-Apr-2023 21:34
 */

package perminov;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Streams1 {

    public static void main(String[] args) {
        // Task 1. Отсортировать список строк в порядке убывания длины строк.
        List<String> words = Arrays.asList("apple", "banana", "pear", "orange", "grape");
        words.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        }).forEach(System.out::println);
        words.stream().sorted((o1, o2) -> o2.length() - o1.length()).forEach(System.out::println);
        // Task 2. Задача: Преобразовать список строк в список их длин.
        ////           List<String> words = Arrays.asList("apple", "banana", "pear", "orange", "grape");
        List<String> countries = Arrays.asList("apple", "banana", "pear", "orange", "grape");
        countries.stream().map(x -> x.length()).forEach(System.out::println);

        // Task 3. Задача: Найти максимальный элемент в списке чисел.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("max=" + numbers.stream().max((x, y) -> {
            if (x > y) return 1;
            if (y < x) return -1;
            return 0;
        }).get());
        System.out.println("max= " + numbers.stream().max(Comparator.naturalOrder()).get());
        System.out.println("max= " + numbers.stream().reduce(0, (x, y) -> x > y ? x : y));


        // Task 4. Задача: Фильтровать список строк по заданному условию.
        List<String> words2 = Arrays.asList("apple", "banana", "pear", "orange", "grape");
        String condition = "app";
        words2.stream().filter(s -> s.contains(condition)).forEach(System.out::println);

        // Task 5. //   Задача: Вычислить среднее значение списка чисел.
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(numbers2.stream().mapToInt(Integer::intValue).summaryStatistics().getAverage());
        System.out.println(numbers2.stream().mapToInt(x->(Integer)x).average().getAsDouble());

    }


}
