/**
 * HomeWorkLists1.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 12-Mar-2023 13:18
 */

package perminov;


import java.util.*;

public class IntegerListDemo {


    //        1) В классе IntegerListDemo создайте список целых чисел.
//        Продемонстрируйте как:
//        добавить в список элемент (в начало и в конец)
//        узнать длину списка
//        удалить элемент из списка (по индексу и без)
//        узнать пустой список или нет
//        обойти список и вывести на консоль каждый элемент.
    public static void simpleListOperations() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);// добавляем элемент в конец
        list.add(2);
        list.add(0, 100); // в начало
        System.out.println("1) Список: " + list);
        System.out.println("Длинна списка: " + list.size());
        list.remove(0);
        System.out.println("Удалили элемент с индексом 0: " + list);
        list.remove((Integer) 2);
        System.out.println("Удалили первое вхождение элемента '2': " + list);
        System.out.println("Список пустой? " + list.isEmpty());
        // используем стрингджойнер, сревисный класс для объединения элементов с разделителем
        StringJoiner resultPrint = new StringJoiner(" | ");
        for (Integer element : list) {
            resultPrint.add(String.valueOf(element));
        }
        System.out.println(resultPrint);
    }

    //        2)
//        Могут ли реализации интерфейса java.util.List хранить одинаковые
//        элементы (дубликаты)? Напишите код программы, который демонстрирует ответ на этот вопрос.
//
    public static void listDuplicates() {
        LinkedList<String> listWithDuplicates = new LinkedList<>();
        listWithDuplicates.addFirst("USA");
        listWithDuplicates.addFirst("Australia");
        listWithDuplicates.addLast("Ukraine");
        listWithDuplicates.add("USA");
        System.out.println("2) Реализация интерфейса List с дубликатами " + listWithDuplicates);
    }


    // 3) создать List наполнить его 10М> элементами
    //        При наполнении списка  сохраняем i- тый элемент в переменную temp
//        перебрать for-each loop
//        classic for и вызываем list.size() для каждой итерации
//        classic for, но list.size() определяем в переменную
//        classic for, list.size() определяем в переменную, перебираем с конца (i--)
//        используя Itertor
//        используя ListIterator
//        для всех случаев сделать замер времени
//        результат вывести в консоль
    public static void bigData() {
        List<Integer> bigList = new ArrayList<>();
        Random r = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < 20_000_000; i++) {
            bigList.add(r.nextInt(100));
        }
        System.out.println("Время:");
        System.out.printf("Наполнение списка: %.0f%n",
                (double) ((System.nanoTime() - startTime) / 1_000_000));

        startTime = System.nanoTime();
        for (Integer element : bigList) {

        }
        System.out.printf("Перебор for-each: %.0f%n",
                (double) ((System.nanoTime() - startTime) / 1_000_000));

        startTime = System.nanoTime();
        for (int i = 0; i < bigList.size(); i++) {
            bigList.size();
        }
        System.out.printf("Перебор for с вызовом size() в каждой итерации: %.0f%n",
                (double) ((System.nanoTime() - startTime) / 1_000_000));

        startTime = System.nanoTime();
        for (int i = 0; i < bigList.size(); i++) {
            int size = bigList.size();
        }
        System.out.printf("Перебор for с сохранением size() в каждой итерации: %.0f%n",
                (double) ((System.nanoTime() - startTime) / 1_000_000));

        startTime = System.nanoTime();
        for (int i = bigList.size() - 1; i >= 0; i--) {
            int size = bigList.size();
        }
        System.out.printf("Перебор for с конца с сохранением size() в каждой итерации: %.0f%n",
                (double) ((System.nanoTime() - startTime) / 1_000_000));

        startTime = System.nanoTime();
        Iterator<Integer> iterator = bigList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        System.out.printf("Перебор с помощью Iterator: %.0f мс%n",
                (double) ((System.nanoTime() - startTime) / 1_000_000));

        startTime = System.nanoTime();
        ListIterator<Integer> listIterator = bigList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        System.out.printf("Перебор с помощью ListIterator: %.0f мс",
                (double) ((System.nanoTime() - startTime) / 1_000_000));
    }

    public static void main(String[] args) {
        // 1)
        //simpleListOperations();

        // 2)
        //listDuplicates();

        // 3)
         bigData();
    }
}
