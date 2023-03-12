import java.util.Arrays;

/**
 * HomeWork.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 22-Feb-2023 18:10
 */

// 1. Дан массив чисел в котором все числа имеют повторения, кроме одного числа. Найти это число
public class HomeWork11 {

   public static boolean isNumberInArray(int[] array, int num){
       for (int i = 0; i < array.length; i++){
           if (array[i] == num) return true;
       }
       return false;
   }
    public static void findRepeats() {
        int[] arrayMain = {0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 0, 7, 8};
        int result = arrayMain[0];
        int[] arrayLeft = {}, arrayRight;
        for (int i = 0; i < arrayMain.length; i++) {
            arrayLeft = Arrays.copyOfRange(arrayMain, 0, i);
            arrayRight = Arrays.copyOfRange(arrayMain, i+1, arrayMain.length);
            if (!isNumberInArray(arrayLeft, arrayMain[i]) && !isNumberInArray(arrayRight, arrayMain[i])){
                System.out.println("Число, которое не имеет повторений в массиве: " + arrayMain[i]);
                break;
            }
        }
    }
}
