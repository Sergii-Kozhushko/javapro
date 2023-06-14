/**
 * Main.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 14-Jun-2023 19:33
 */

package egorov.annotations;

public class Main {
   public static void main(String[] args) {

   }

   @Secured(value = {"read", "write"})
   public static void someMethod() {
      System.out.println("Method with @Secured annotation");

   }

}
