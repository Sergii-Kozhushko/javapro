package egorov;

/**
 * de.telran.java.egorov.Island.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 23-Feb-2023 17:54
 */

/*
Задача Острова.
Идея алгоритма:
- двигаемся по массиву слева напраов сверх вниз
- если находим 1-ку, то пытаемся последовательно двигаться из текущей ячейки влево, вправо, вниз, вверх
- двигаться значит смотреть что будет в следующей ячейке - если 1-ка то можно двигаться, если 0 - нельзя
- далее анализруем каждую ячейку не является ли она крайней, елси является то считаем остров невалидным
- каждую пройденную ячейку острова помеяаем 2-кой, чтобы не наткнуться на ее при дальнейшем прохождении массива
* */
public class Island {
   private static final int iMax = 10;
   private static final int jMax = 10;
   private static int[][] array = new int[iMax][jMax];
//   {
//           {0, 0, 0, 0, 0},
//           {0, 1, 1, 1, 0},
//           {1, 0, 0, 0, 0},
//           {1, 0, 0, 1, 0},
//           {1, 0, 0, 1, 0}
//   }; //
// = {
//   {1,  1,  0,  0,  1,  1,  0,  0,  1, 1},
//   {0,  0,  1,  0,  0,  1,  0,  1,  1, 0},
//   {1,  1,  0,  1,  0,  0,  0,  1,  1, 1},
//   {1,  0,  1,  1,  1,  0,  1,  1,  0, 0},
//   {1,  0,  1,  1,  1,  0,  1,  0,  0, 0},
//   {0,  1,  1,  0,  1,  1,  1,  0,  1, 1},
//   {1,  0,  1,  1,  1,  0,  0,  0,  1, 0},
//   {0,  1,  0,  0,  0,  1,  0,  0,  0, 0},
//   {0,  1,  1,  0,  1,  0,  0,  1,  1, 0},
//   {0,  1,  0,  1,  1,  0,  0,  1,  1, 0}
//};
   private static int islandCount;
   private static int maxArea, currentArea;
   private static boolean isCurrentIslandValid;


   private static void fillArrayRandom(){
      for (int x = 0; x < array.length; x++){
         for (int y = 0; y < array[x].length; y++) {
            array[x][y] = (int) (Math.random()*2);
         }
      }
   }
   private static void printArray() {
      for (int x = 0; x < array.length; x++) {
         for (int y = 0; y < array[x].length; y++) {
            System.out.print(array[x][y] + "  ");

         }
         System.out.println();
      }
   }
   private static void findWholeIsland(int i, int j){
      // если можно двигаться вправо, то ставим ячейке справа = 2 и рекурсивоно вызываемся
      // отметить элемент, как пройденный
      array[i][j] = 2;
      if (!isCeilValid(i, j)) {
         isCurrentIslandValid = false;
      } // если клетка с
      currentArea++;
      // можно двигаться вправо?
      if (j < jMax-1 && array[i][j+1] == 1){
         findWholeIsland(i, j+1);
      }
      // можно двигаться вниз?
      if (i < iMax-1 && array[i+1][j] == 1){
         findWholeIsland(i+1, j);
      }
      // можно двигаться вверх?
      if (i != 0 && array[i-1][j] == 1)
         findWholeIsland(i-1, j);
      // можно двигаться влево?
      if (j !=0 && array[i][j-1] == 1)
         findWholeIsland(i, j-1);
   }
   private static boolean isCeilValid(int i, int j){
      if (i == 0 || i == iMax-1 || j == 0 || j == jMax-1) return false;
      //if (array[i][j-1]  == 0 && array[i-1][j] == 0)
      return true;
   }
   public static void main(String[] args) {
      fillArrayRandom();
      printArray();
      // j - столбик, второй индекс массива
      // i - строка, первый индекс
      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array.length; j++) {
            // найдена первая ячейка острова ?
            if (array[i][j] == 1){
               // тогда, найти все ячейки этого острова, пометить их как = 2 и определить является ли ячейка тру островом
               isCurrentIslandValid = true;
               findWholeIsland(i, j);
               if (isCurrentIslandValid) {
                  if (currentArea > maxArea) maxArea = currentArea;
                  islandCount++;
               }
               currentArea = 0;
            }
         }
      }
      System.out.println("Число островов: " + islandCount);
      System.out.println("максимальная площадь острова: " + maxArea);

   }

}
