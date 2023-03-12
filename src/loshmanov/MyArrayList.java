/**
 * ArrayList.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 06-Mar-2023 17:46
 */

package loshmanov;

// ДЗ
//         Даны два ArrayList, элементы которых упорядочены. Объединить их в трерий ArrayList,
//         элементы которого тоже должны быть отсортированы.
//         Example 1:
//         Input: list1 = [1,2,4], list2 = [1,3,4]
//         Output: [1,1,2,3,4,4]
//         Example 2:
//         Input: list1 = [], list2 = []
//         Output: []
//         Example 3:
//         Input: list1 = [], list2 = [0]
//         Output: [0]
//
//         Task 2.
//         Пусть дан ArrayList нечетной длины. Используя только Iterator (не прибегая к индексам и длине списка),
//         вывести на экран элемент, находящийся ровно посередине списка.
//         Example 1:
//         Input: list = [1,2,4]
//         Output: 2
//         Example 2:
//         Input: list = [1,2,3,4,5]
//         Output: 3
//         Example 3:
//         Input: list = [1]
//         Output: 1

import java.util.*;

public class MyArrayList {

    // Task 2
    // алгоритм: вручную найти размер списка,пройти итераторм до середины
    public static Integer getListMiddle(List<Integer> list){
        if (list.size() % 2 == 0) {
            System.out.println("Список имеет четную длинну");
            return null;
        }
        Iterator<Integer> iterator = list.iterator();

        // находим вручную размер листа
        int size = 0;
        while (iterator.hasNext()){
            size++;
            iterator.next();
        }
        // обнуляем курсор итератора
        iterator = list.iterator();
        int index = 0;
        // проходимся по итератору, увеличивая счетчик и с равнивая с половиной полученной длинны
        while (iterator.hasNext()){
            if (index == size / 2 ){
                return iterator.next();
            }
            index++;
            iterator.next();
        }
        return null;
    }

    // Task 2
    // алгоритм - удалять по одному элементу, проходя прямым и оратнмы итератором одновременно.
    // Пока не останется один элемент
    public static int getListMiddleSmirnovVariant(List<Integer> list){
        ListIterator<Integer> iterator1 = list.listIterator(0);
        ListIterator<Integer> iterator2 =  list.listIterator(list.size());
        Integer result1, result2;
        while (iterator1.hasNext() && iterator2.hasPrevious()){
            result1 = iterator1.next();
            result2 = iterator2.previous();
            if (result1 == result2 ) return result1;
        }
        return 0;
    }

    // Алгоритм: создаем два итератора: от начала и от конца.
    // Одновременено двигаемся в итераторах, пока не достигнем середины
    public static int getListMiddleNew(List<Integer> list){
        ListIterator<Integer> iterator1 = list.listIterator(0);
        ListIterator<Integer> iterator2 =  list.listIterator(list.size());
        Integer result1, result2;
        while (iterator1.hasNext() && iterator2.hasPrevious()){
            result1 = iterator1.next();
            result2 = iterator2.previous();
            if (result1 == result2 ) return result1;
        }
        return 0;
    }


    // Task 1
    // Некрасивый, но рабочий код.
   //Алгоритм:
    // 1.Берем элемент первого списка, если не достигли конца
    // 2. Берем элемент второго списка, если не достигли конца
    // 3. Меньший из них добавляем в результат и увеличиваем счетчик этого списка на 1
    // 4. Если достигли конца одного из счетчиков, то добавляем все оставшиеся элементы второго
    public static ArrayList<Integer> orderLists(List<Integer> list1, List<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        Integer element1 = null, element2 = null;
        boolean list1HasNext, list2HasNext;
        int index1 = 0, index2 = 0;
        while (index1 < list1.size() || index2 < list2.size()) {
            // начальное значение из первого листа
            if (element1 == null && list1.size() > 0) {
                element1 = list1.get(index1);
            }
            //  из второго
            if (element2 == null && list2.size() > 0) {
                element2 = list2.get(index2);
                //index2++;
            }
            list1HasNext = index1 < list1.size();
            list2HasNext = index2 < list2.size();
            if (list1HasNext && list2HasNext) {
                if (element1 < element2) {
                    result.add(element1);
                    index1++;
                    if (index1 < list1.size()) element1 = list1.get(index1);
                } else {
                    result.add(element2);
                    index2++;
                    if (index2 < list2.size()) element2 = list2.get(index2);
                }
            } else {
                if (list1HasNext) {
                    result.add(element1);
                    index1++;
                    if (index1 < list1.size()) element1 = list1.get(index1);
                }
                if (list2HasNext) {
                    result.add(element2);
                    index2++;
                    if (index2 < list2.size()) element2 = list2.get(index2);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        //System.out.println(orderLists(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 30)));
        System.out.println(getListMiddle(Arrays.asList(1,2,3,4,5)));
        System.out.println(getListMiddleNew(Arrays.asList(1,2,3,4,5)));

    }

}
