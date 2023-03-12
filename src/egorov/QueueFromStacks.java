/**
 * TwoStack.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 03-Mar-2023 10:21
 */

package egorov;

import java.util.Stack;

// Задача: реализовать очередь, использовав только два стека внутри
public class QueueFromStacks<T> {
   private Stack<T> stack1 = new Stack<>();
   private Stack<T> stack2 = new Stack<>();

   // метод помещает элемент в очередь
   public void push(T element){
      stack1.push(element);
      //return element
   }

   // извлекает-удаляет первый элемент очереди
   public T pop(){
      // если второй стек пуст, то перекидываем все элементы из стека1 в стек2
      if (stack2.size() == 0) {
         while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
         }
      }
      else {
         // удаляем верхний элемент из стека2
         return stack2.pop();
      }
      return null;
   }
   public void print(){
      for (int i = stack2.size()-1; i >= 0; i--) {
         System.out.print(stack2.get(i) + " ");
      }
      for (int i = 0; i < stack1.size() ; i++) {
         System.out.print(stack1.get(i) + " ");
      }
   }

   public static void main(String[] args) {
      QueueFromStacks<String> queue = new QueueFromStacks<>();
      queue.pop();
      queue.push("a1");
      queue.push("a2");
      queue.push("a3");
      queue.push("a4");
      queue.pop(); // удаляем a1
      queue.push("a5");
      queue.push("a6");
      queue.push("a7");
      queue.pop(); // удаляем второй
      queue.push("a8");
      queue.push("a9");
      queue.print();
   }
}
