/**
 * HomeWork2803.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 23-Mar-2023 21:46
 */

package loshmanov;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HomeWork2803 {

   //   Task 1. Given a string s, find the first non-repeating character
//   in it and return its index. If it does not exist, return -1.
//   Example 1:
//   Input: s = "leetcode"
//   Output: 0
//   Example 2:
//   Input: s = "loveleetcode"
//   Output: 2
//   Example 3:
//   Input: s = "aabb"
//   Output: -1
//   Подсказка: можно решить, используя HashMap.
   public static int findFirstNonRepeatingChar(String str){
      char[] chars = str.toCharArray();
      HashMap<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
               map.put(chars[i], map.get(chars[i]) + 1);
            }
            else{
               map.put(chars[i], 1);
            }
      }
      for (int i = 0; i < chars.length; i++) {
         if (map.get(chars[i]) == 1) return i;
      }
      return -1;
   }

//           Task 2. Что выведет фрагмент кода? Объяснить.
//import java.util.HashSet;
//   class Person {
//      String name;
//      Person(String name) { this.name = name; }
//      public String toString() { return name; }
//   }
//   class TestHashSet {
//      public static void main(String args[]) {
//         HashSet set = new HashSet<>();
//         Person p1 = new Person("Иван");
//         Person p2 = new Person("Мария");
//         Person p3 = new Person("Пётр");
//         Person p4 = new Person("Мария");
//         set.add(p1);
//         set.add(p2);
//         set.add(p3);
//         set.add(p4);
//         System.out.print(set.size());
//      }
//   }
// ОТВЕТ: фрагмент выведет 4,тк при добавлении в сет будут добавляться уникальные объекты, а не поля Person.name


//
//   Task 3. Дана строка. Вывести количество появлений каждого символа в этой строке. Например:
//   Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu feugiat tellus. Nam molestie diam sed libero egestas pellentesque. Nulla.
//
//
//   Символ e встречается 20 раз.
public static void printCharCount(String str){
       char[] chars = str.toCharArray();
       HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < chars.length; i++) {
        Integer count = map.get(chars[i])==null?0:map.get(chars[i]);
        map.put(chars[i], count+1);
    }
    for (Map.Entry entry : map.entrySet()){
        System.out.printf("Символ '%c' встречается %d раз%n", entry.getKey(), entry.getValue());
    }
}

   public static void main(String[] args) {
      System.out.println(findFirstNonRepeatingChar("aabbv"));
      printCharCount("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu feugiat tellus. Nam molestie diam sed libero egestas pellentesque. Nulla.");
   }

}
