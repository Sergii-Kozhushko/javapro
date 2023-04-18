/**
 * WarAndPeace.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 18-Apr-2023 17:28
 */

package egorov;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class WarAndPeace {
   public static void main(String[] args) throws Exception  {

      Stream.of(Files.lines(Paths.get("c://11/war-and-peace.txt"), StandardCharsets.UTF_8)
              .collect(Collectors.joining(System.lineSeparator()))
              .trim().split("[, . :!?—\\s]"))
              .filter(x->!x.equals("")&& !x.equals(" –") && !x.equals("–") && !x.equals("]"))
              .collect(Collectors.groupingBy(x->x.hashCode()))
              .entrySet()
              .stream()
              .sorted((x,y)->y.getValue().size()- x.getValue().size())
              .forEach(x-> System.out.println(x.getValue().get(0) + " - " + x.getValue().size()));
   }

}
