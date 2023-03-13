/**
 * HomeWork14.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 11-Mar-2023 23:16
 */

package loshmanov;

import java.util.*;

public class HomeWork14 {

// // Task1. Given an integer array nums sorted in non-decreasing order,
//// remove the duplicates in-place such that each unique element appears only once.
//// The relative order of the elements should be kept the same.
////
////Example 1:
////Input: nums = [1,1,2]
////Output: 2, nums = [1,2,_]
////Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
////It does not matter what you leave beyond the returned k (hence they are underscores).

    // Поиск количества ненулл элементов в отсортированном массиве {1,2,3,null}=3
    public static int findNotNullNumberInArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) return i;
        }
        return array.length;
    }

    // метод сдвигает влево массив начиная с элемента start. Массив мы не возвращаем тк изменяем массив, переданный по ссылке
    public static void shiftArrayLeft(Integer[] array, int start) {
        if (start == 0) return;
        for (int i = start; i < array.length; i++) {
            if (array[i] != null)
                array[i - 1] = array[i];
        }
    }

    // если два соседних элемента равны, то сдвигаем весь массив влево на 1 элемент
    public static Integer[] removeDuplicatesByArray(Integer[] arraySource) {
        // копируем массив
        Integer[] array = new Integer[arraySource.length];
        System.arraycopy(arraySource, 0, array, 0, arraySource.length);

        int index = 0; //  индекс прохождения массива
        int countNull = 1; //  количество сдвигов влево

        while (true) {
            if (index < array.length - 1 && array[index] != null && array[index] == array[index + 1]) {
                // если нашли два равных элемента, то сдвигаем массив влево
                shiftArrayLeft(array, index + 1);
                array[array.length - countNull] = null; // присваиваем освободившемуся элементу с конца нулл
                countNull++;
            }
            // если прошлись по всему массиву
            if (index == array.length - 1 || array[index + 1] == null) {
                return array;
            }
            // если идут подряд 3 одинаковых элемента, то индекс не увеличивать,
            // тк надо еще раз сдвинуть, поэтому добавил эту проверку
            if (array[index] != array[index + 1]) {
                index++;
            }
        }
    }

    // Task 1. Решение с помощью списка
    public static Integer[] removeDuplicatesByList(Integer[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!list.contains(array[i])) {
                list.add(array[i]);
            }
        }
        return (Integer[]) list.toArray(new Integer[list.size()]);
    }

    // Task 1. Решение сетом
    public static Integer[] removeDuplicatesBySet(Integer[] array) {
        Set<Integer> set = new HashSet<>(Arrays.asList(array));
        Integer[] result = set.toArray(new Integer[set.size()]);
        return result;
    }

    public static Integer[] removeDuplicatesByXOR(Integer[] array) {
        List<Integer> list = Arrays.asList(array);

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0, j = 1; i < list.size() - 1; i++, j++) {
            if ((list.get(i) ^ list.get(j)) != 0) {
                arr.add(list.get(i));
            }
            if ((list.get(i) ^ list.get(j)) != 0 && j == list.size() - 1) {
                arr.add(list.get(j));
            }
        }
        for (int l = arr.size(); l < list.size(); l++) {
            arr.add(null);
        }
        return (Integer[]) arr.toArray(new Integer[arr.size()]);
    }

    public static Integer[] removeDuplicatesBySimpleEqual(Integer[] array) {

        List<Integer> list = Arrays.asList(array);

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0, j = 1; i < list.size() - 1; i++, j++) {
            if (list.get(i) != list.get(j)) {
                arr.add(list.get(i));
            }
//            if (list.get(i) != list.get(j) && j == list.size() - 1) {
//                arr.add(list.get(j));
//            }
        }
        for (int l = arr.size(); l < list.size(); l++) {
            arr.add(null);
        }
        return (Integer[]) arr.toArray(new Integer[arr.size()]);

    }

    public static Integer[] removeDuplicatesByCompareNext(Integer[] array) {
        Integer[] result = new Integer[array.length];
        int count = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] != array[i+1]) {
                result[count] = array[i];
                count++;
            }
        }
        result[count] = array[array.length-1];
        return result;
   }


    //    Task 2.
//    Given a non-empty array of integers nums, every element appears twice except for one.
//    Find that single one.
//    Example 1:
//    Input: nums = [2, 2, 1, 0, 0]
//    Output: 1

    // Такск 2. Сложность O 2n. перебираем массив. ищем сколько повторений текущего элемента слева и справа.
    public static int findOneByArray(Integer[] array) {
        boolean foundRepeats;
        for (int i = 0; i < array.length; i++) {
            foundRepeats = false;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && i != j) {
                    foundRepeats = true;
                    break;
                }
            }
            if (!foundRepeats) {
                return array[i];
            }
        }
        return 0;

    }

    // {2, 2, 1, 1, 0, 10, 0}
    // вспомогательный метод, находит количество вхождений числа в массив
    public static int findElementCount(Integer[] array, int toFind) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == toFind) result++;
        }
        return result;
    }

    // Таск 2. формирует мапу, где ключ - количество вхождений, а значение сам элемент.
    // Красиво возвращаем результат
    public static int findOneByMap(Integer[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(findElementCount(array, array[i]), array[i]);
        }
        return map.get(1);
    }

    public static void main(String[] args) {
        // Task 1
        Integer[] arraySource = {0, 0, 0, 0, 1, 1, 2, 2, 5, 10, 10};
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(arraySource));

        long timeStart = System.currentTimeMillis();
        int roundCount = 10_000_000; // количество циклов, для того, чтобы увидеть какой алгоритм быстрее
        // алгоритм сдвигом массива
        for (int i = 0; i < roundCount; i++) {
            removeDuplicatesByArray(arraySource);
        }
        Integer[] resultArray = removeDuplicatesByArray(arraySource);
        System.out.println("1. Обработка с помощью сдвига массива:");
        System.out.print(Arrays.toString(resultArray) + " Результат: " + findNotNullNumberInArray(resultArray) + ".");
        System.out.printf(" Время : %.0f%n%n",
                (double) (System.currentTimeMillis() - timeStart));

        // алгоритм списком
        timeStart = System.currentTimeMillis();
        for (int i = 0; i < roundCount; i++) {
            removeDuplicatesByList(arraySource);
        }
        resultArray = removeDuplicatesByList(arraySource);
        System.out.println("2. Обработка с помощью списка:");
        System.out.print(Arrays.toString(resultArray) + " Результат: " + resultArray.length + ".");
        System.out.printf(" Время : %.0f%n%n",
                (double) (System.currentTimeMillis() - timeStart));

        // алгоритм сетом (набором)
        timeStart = System.currentTimeMillis();
        for (int i = 0; i < roundCount; i++) {
            removeDuplicatesBySet(arraySource);
        }
        resultArray = removeDuplicatesBySet(arraySource);
        System.out.println("3. Обработка с помощью сета (набора):");
        System.out.print(Arrays.toString(resultArray) + " Результат: " + resultArray.length + ".");
        System.out.printf(" Время : %.0f%n%n",
                (double) (System.currentTimeMillis() - timeStart));

        //алгоритм XOR
        timeStart = System.currentTimeMillis();
        for (int i = 0; i < roundCount; i++) {
            removeDuplicatesByXOR(arraySource);
        }
        resultArray = removeDuplicatesByXOR(arraySource);
        System.out.println("4. Обработка с помощью цикла с двумя индексами + XOR:");
        System.out.print(Arrays.toString(resultArray) + " Результат: " + findNotNullNumberInArray(resultArray) + ".");
        System.out.printf(" Время : %.0f%n%n",
                (double) (System.currentTimeMillis() - timeStart));

        //алгоритм Простосравнение
        timeStart = System.currentTimeMillis();
        for (int i = 0; i < roundCount; i++) {
            removeDuplicatesBySimpleEqual(arraySource);
        }
        resultArray = removeDuplicatesBySimpleEqual(arraySource);
        System.out.println("5. Обработка с помощью цикла с двумя индексами + сравнение:");
        System.out.print(Arrays.toString(resultArray) + " Результат: " + findNotNullNumberInArray(resultArray) + ".");
        System.out.printf(" Время : %.0f%n%n",
                (double) (System.currentTimeMillis() - timeStart));

        // Массив, спавнение соседних
        timeStart = System.currentTimeMillis();
        for (int i = 0; i < roundCount; i++) {
            removeDuplicatesByCompareNext(arraySource);
        }

        resultArray = removeDuplicatesByCompareNext(arraySource);
        System.out.println("6. Обработка с помощью массива и сравнения соседних элементов:");
        System.out.print(Arrays.toString(resultArray) + " Результат: " + findNotNullNumberInArray(resultArray) + ".");
        System.out.printf(" Время : %.0f%n%n",
                (double) (System.currentTimeMillis() - timeStart));



        // Task 2
        System.out.println(findOneByArray(new Integer[]{2, 2, 1, 3, 5, 3, 3, 5}));
        System.out.println(findOneByMap(new Integer[]{2, 2, 1, 3, 5, 3, 3, 5}));

    }

}
