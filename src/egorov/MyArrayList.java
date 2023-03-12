/**
 * ArrayList.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 05-Mar-2023 14:45
 */

package egorov;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

// Написать класс который содержит ArrayList и методы:
//        заполняют лист рандомными цифрами
//
//      перебирают Итератором и выводят на экран все четные
//        перебирают итератором и выводят на экран все нечетные
//
//      генерируют рандомную стрингу длиной 5
//        перебираю итератором эту стрингу с конца и выводит тот символ который нужен если он есть,
//        если нет то выдает сообщение
public class MyArrayList {
    private ArrayList<Integer> list = new ArrayList<>();
    private String string = "";

    // заполняет список случайными числами
    public void fillIntListRandom(int n) {
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            list.add(random.nextInt(0, 100));
        }
    }

    public void printIntList() {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    // распечатывает четные элементы
    public void printOdd() {
        Iterator iterator = list.iterator();
        System.out.print("Нечетные элементы списка: ");
        while (iterator.hasNext()) {
            Integer element = (Integer) iterator.next();
            if (element % 2 != 0) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }

    // распечатывает нечетные элементы
    public void printEven() {
        Iterator iterator = list.iterator();
        System.out.print("Четные элеменеты списка: ");
        while (iterator.hasNext()) {
            Integer element = (Integer) iterator.next();
            if (element % 2 == 0) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }

    // создает рандомную строку из 5-ти латинских символов и знаков, 64-122 - аски коды символов
    public void generateRandomString() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            string += (char) random.nextInt(64, 122);
        }
    }

    // ищет в сгенерированной строке символ
    public void findChar(char charToFind) {
        CharacterIterator ci = new StringCharacterIterator(string);
        boolean isFound = false;
        for (char c = ci.last(); c != CharacterIterator.DONE; c = ci.previous()) {
            if (c == charToFind) {
                System.out.printf("Символ '%c' найден в строке '%s'%n", charToFind, string);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.printf("Символ '%c' НЕ найден в строке '%s'%n", charToFind, string);
        }

    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.fillIntListRandom(10);
        myArrayList.printIntList();
        myArrayList.printOdd();
        myArrayList.printEven();

        myArrayList.generateRandomString();
        myArrayList.findChar('a');
    }

}
