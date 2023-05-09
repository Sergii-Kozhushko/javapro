/**
 * ApplicationStart.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 09-May-2023 13:42
 */

package egorov.exception;

import java.util.Arrays;
import java.util.List;

public class ApplicationStart {

    /**
     * [1 2 3]
     * [4 5 6]
     * -------
     * [1 4]
     * [2 5]
     * [3 6]
     * **********
     * [1 2 3]
     * [4 5 6]
     * [7 8 9]
     * --------
     * [1 4 7]
     * [2 5 8]
     * [3 6 9]
     */
    public static int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    public static void changeArray() {
        int[][] result = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result[j][i] = array[i][j];
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

//      private static int[][] transpose(int[][] matrix) {
//         return null;
//      }

    /**  0 1  2    0   1  2  3
     0* [1 2 3]   0[1  2  3  4]
     1* [4 5 6]   1[5  6  7  8]
     2* [7 8 9]   2[9  10 11 12]
                  3[13 14 15 16]
     * ---------
         0 1 2    0[13  9  5   1]
    0 * [7 4 1]   1[14  10 6  2]
    1 * [8 5 2]   2[15  11 7  3]
    2 * [9 6 3]   3[16  12 8  4]
     */

    private static int[][] rotate(int[][] matrix) {
        if (matrix == null){
            throw new MatrixNullException(ErrorMessage.MATRIX_NULL);
        }
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

            }
        }
        return null;
    }

    /**
     * [ 1  2  3  4]
     * [ 5  6  7  8]
     * [ 9 10 11 12]
     * [13 14 15 16]
     * ---------
     * sum D
     * sum U
     */

      private static void sumUD(int[][] matrix) {
          int sumUp = 0, sumDown = 0;
          for (int i = 0; i < matrix.length; i++) {
              for (int j = 0; j < matrix[i].length; j++) {
                  if (j > i){
                      sumUp += matrix[i][j];
                  }
                  if (j < i){
                      sumDown += matrix[i][j];
                  }
              }
          }
          System.out.println("Сумма ниже диагонали: " + sumDown);
          System.out.println("Сумма выше диагонали: " + sumUp);
      }
    public static void main(String[] args) {
        //changeArray();
        //sumUD(array);
        rotate(null);
    }

}
