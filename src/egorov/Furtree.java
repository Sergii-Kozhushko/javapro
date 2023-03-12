/**
 * Furtree.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-Feb-2023 20:47
 */

package egorov;

public class Furtree {
    private static final int maxRow = 15;
    private static int[][] array = new int[maxRow][];

    private static void printArray(){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < array.length ; i++) {
            array[i] = new int[i+1];
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == 0 || j == array[i].length-1){
                    array[i][j] = 1;
                }
                else {
                    array[i][j] = array[i-1][j-1] + array[i-1][j];
                }


            }
        }
        printArray();

    }

}
