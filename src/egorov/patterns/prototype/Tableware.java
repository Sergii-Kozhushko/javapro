/**
 * Tableware.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 11-Mar-2023 17:51
 */

package egorov.patterns.prototype;

public class Tableware implements Cloneable {
   private String material;
   private String color;

   public Tableware(Tableware tableware) {
      if (tableware != null) {
         material = tableware.material;
         color = tableware.color;
      }
   }

   @Override
   protected Object clone() throws CloneNotSupportedException {
      return super.clone();
   }
}
