/**
 * HomeWork11.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 25-Feb-2023 23:33
 */

package loshmanov;

// Дан массив nums целых чисел и целое число target,
// найдите индексы двух элементов массива, чтобы сумма этих значений была равна target.
// Предполагается, что существует всегда только одно решение и нельзя
// использовать один и тот же элемент массива дважды.
// Example 1: Input: nums = [2,7,11,15], target = 9
// Output: [0,1] Explanation: Because nums[0] + nums[1] == 9,
// we return [0, 1]. Example 2: Input: nums = [3,2,4], target = 6
// Output: [1,2] Example 3: Input: nums = [3,3], target = 6 Output: [0,1]

public class HomeWork11 {
    public final static int[] array = {1, 2, 10, 12, 7, 0, 2};
    public static int index1, index2;

    public static String findSum(int n) {
        for (int i = 0; i < array.length; i++){
            for (int j = i+1; j < array.length; j++) {
                if (array[i] + array[j] == n){
                    index1 = i;
                    index2 = j;
                    return "[" + index1 +", " + index2 + "]";
                }
            }
        }
        return "Elements not found";
    }

    public static void main(String[] args) {
        System.out.println(findSum(19));

    }

}
