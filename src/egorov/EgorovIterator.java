/**
 * EgorovIterator.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 09-Mar-2023 13:50
 */

package egorov;

import java.util.List;

public class EgorovIterator {
    private int cursor;

    public EgorovIterator() {
        cursor = 0;
    }

    boolean hasNext(List<Integer> list) {
        return cursor < list.size();
    }

    Integer next(List<Integer> list) {
        return null;
    }

    String remove(Integer number) {
        //если объект есть то-Объект такой то удален + количество объектов
        //если нет то - объекта такого то нету
        return null;
    }

    boolean hasPrevious(List<Integer> list) {
        return true;
    }

    Integer previous(List<Integer> list) {
        return 0;
    }

}


