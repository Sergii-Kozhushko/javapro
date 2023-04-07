/**
 * Backpack.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 06-Apr-2023 19:03
 */

package algorythm;

import java.util.ArrayList;
import java.util.List;
public class Backpack {

    // метод возвращает

    static List<Thing> findThings(int bpCapacity, List<Thing> things) {
        List<Thing> currentList = new ArrayList<>();
        List<Thing> resultList = new ArrayList<>();
        int currentValueSum, maxValueSum = 0, currentWeightSum;
        // вычисляем число, которое имеет все включеннеы биты по размеру списка 3 ->111
        int maxBits = (int) Math.pow(2,things.size());
        String str;
        for (int i = 1; i < maxBits; i++){

            // получаем в строку с битами
            str = String.format("%0" + things.size() +"d",Integer.valueOf(Integer.toBinaryString(i)));
            //  проходимся по строке с битами и ложим в текущий список вещи там, где бит=1
            currentList.clear();
            currentValueSum = 0;
            currentWeightSum = 0;
            for (int j = 0; j < str.length(); j++){
                if (str.charAt(j) == '1'){
                    currentList.add(things.get(j));
                    currentValueSum += things.get(j).value;
                    currentWeightSum += things.get(j).weight;
                    // если превысили вес, то дальше не перебираем
                    if (currentWeightSum > bpCapacity){
                        break;
                    }
                }
            }
            // нашли более выгодную комбинацию?
            if (currentWeightSum <= bpCapacity && currentValueSum > maxValueSum){
                maxValueSum = currentValueSum;
                resultList = new ArrayList<>(currentList);
            }
        }
        System.out.println("Вместительность рюкзака: " + bpCapacity);
        System.out.print("Стартовый список вещей: ");
        things.stream().forEach(x->System.out.print(x + " "));
        System.out.println();
        System.out.println();
        System.out.print("Можем взять эти вещи: ");
        resultList.stream().forEach(x->System.out.print(x + " "));
        System.out.println();
        System.out.print("Вес ");
        System.out.print(resultList.stream().map(x->x.weight).mapToInt(Integer::intValue).sum());
        System.out.print(", стоимость $");
        System.out.println(resultList.stream().map(x->x.value).mapToInt(Integer::intValue).sum());

        return resultList;
    }


    public static void main(String[] args) {
        List<Thing> list = new ArrayList<>();
        list.add(new Thing(2, 1000));
        list.add(new Thing(4, 3000));
        list.add(new Thing(1, 600));
        list.add(new Thing(2, 700));
        list.add(new Thing(3, 600));
        list.add(new Thing(2, 800));
        findThings(10, list);

    }
}

class Thing {
    int weight;
    int value;

    public Thing(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "w=" + weight +
                ", $" + value +
                '}';
    }
}
