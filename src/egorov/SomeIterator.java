/**
 * SomeIteartor.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 09-Mar-2023 18:35
 */

package egorov;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//  - {1 , 10, 20, 5}   {1}
public class SomeIterator {
   int cursor;
   boolean directionForward;
   private Integer array[];

   public SomeIterator(List<Integer> list, boolean directionForward) {
      array = (Integer[]) list.toArray();
      this.directionForward = directionForward;
      if (directionForward == true) {
         cursor = -1;
      }
      else {
         cursor = array.length - 1;
      }

   }

   boolean hasNext(){
      return cursor + 1 < array.length;
   }

   boolean hasPrevious(){
      return cursor >= 0;
   }


   Integer next(){
      if (hasNext()) {
         Integer temp = array[cursor + 1];
         cursor++;
         return temp;
      }
      else {
         System.out.println("Error: iterator has no next element");
         return null;
      }
   }

   Integer previous(){
      if (hasNext()) {
         Integer temp = array[cursor + 1];
         cursor++;
         return temp;
      }
      else {
         System.out.println("Error: iterator has no next element");
         return null;
      }

   }


   public static void main(String[] args) {
      ArrayList<Integer> arrayList = new ArrayList<>();
      arrayList.add(1);
      arrayList.add(2);
      ListIterator<Integer> listIterator = arrayList.listIterator(arrayList.size());

      System.out.println(listIterator.next());


   }
}
