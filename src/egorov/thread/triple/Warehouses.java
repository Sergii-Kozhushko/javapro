/**
 * Warehouses.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 30-May-2023 22:26
 */

package egorov.thread.triple;

import java.util.ArrayDeque;

/*
1. Логистика доставляет материалы на фабрику
2. Фабрика изготавливает товар из материала. Товар сразу оказывается на складе магазина. Мы не учитываем перевозку
фабрика-магазин
3. Магазин продает товары.
4. Если товар закончился или дошел до мин количества, то магазин дает сигнал логистике везти материалы.
 */

public class Warehouses {
   public static int MIN_MATERIAL_QUANTITY = 3;
   public static int MIN_PRODUCTS_QUANTITY = 3;


   public static int countProducts = 1; // счетчик материалов и товаров
   ArrayDeque<String> materialList = new ArrayDeque<>();// материалы на фабрике
   ArrayDeque<String> productList = new ArrayDeque<>(); //  товары в магазине



   synchronized public void deliveryMaterialToFactory(){
      if  (materialList.size() > MIN_MATERIAL_QUANTITY){
         try {
            wait();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      // доставляем материал на фабрику
      materialList.add(String.valueOf(countProducts));
      System.out.print("Delivered materials #" + countProducts +" to Factory. ");
      countProducts++;
      printSystemState();
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
      notifyAll();
   }

   synchronized public void produceGood(){
      while (materialList.isEmpty()){
         try {
            wait();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }

      String material = materialList.removeFirst();
      productList.add(material);
      System.out.print("Produced good #" + material + " for shop. ");
      printSystemState();
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
      notifyAll();
   }

   synchronized public void sellProduct(){
      while (productList.isEmpty()){
         try {
            wait();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }

      }

      String good = productList.removeFirst();
      System.out.print("Shop sold item #" + good + " ");
      printSystemState();

      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      // если продали все товары, то послать сигнал, что пора завозить материалы
      if (productList.size() < MIN_PRODUCTS_QUANTITY){
         notifyAll();
      }
   }

   public void printSystemState(){
      System.out.println("Materials: " + materialList.size() + ". Products: " + productList.size());
   }



}
