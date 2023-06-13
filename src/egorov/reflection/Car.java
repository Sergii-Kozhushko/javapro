/**
 * Car.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 03-Jun-2023 15:03
 */

package egorov.reflection;

public class Car extends Mechanical {
   private String model;

   public Car(String model) {
      this.model = model;
   }

   public Car() {
   }

   public boolean startEngine(boolean withKey){
      return true;
   }

   @Override
   public String toString() {
      return "Car{" +
              "model='" + model + '\'' +
              ", serial='" + serial + '\'' +
              '}';
   }

   private void privateMethod(){
      System.out.println("Private method of Car Class called!");
   }
}
