/**
 * MyIterator.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 07-Mar-2023 20:05
 */

package egorov;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyIterator<T> implements Iterator {
   private T[] array;// {1, null, 2, 3}
   private int cursor;

   public MyIterator() {
   }

   public MyIterator(List<T> array) {
      this.array = (T[]) array.toArray();
      cursor = 0;
   }

   @Override
   public boolean hasNext() {
      return cursor < array.length;
   }

   @Override
   public T next() {
      if (cursor < array.length){
         cursor++;
         return array[cursor - 1];
      }
      else throw new NoSuchElementException();
   }

   @Override
   public void remove() {
      //if ()
      //System.arraycopy();
      //T[] aa = new T[10];
      //T[] result = new T[10];
      //T some = new T;
      //mas = (T[]) Array.newInstance(T.Class, 10);
      //ArrayList<Integer> arrayList = new ArrayList<>();
      //Iterator iterator = arrayList.listIterator();

      //array.
      //Iterator.super.remove();
   }

   public static void main(String[] args) {
      ArrayList<Integer> arrayList = new ArrayList<>();
      arrayList.add(2);
      arrayList.add(3);
      arrayList.add(5);

      MyIterator<Integer> myIterator = new MyIterator<>(arrayList);
      while (myIterator.hasNext()){
         System.out.print(myIterator.next() + " ");
      }
      myIterator.next();
   }
}
