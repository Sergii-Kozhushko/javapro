/**
 * MyQueue.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 04-May-2023 20:49
 */

package algorythm;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//   Queue - реализовать используя массив (Array)
//   pushToEnd(int data) - вставляет элемент в конец queue
//   remove() - удаляет элемент из начала queue
//   peek() - возвращает элемент из начала не удаляя его
//   isEmpty() - boolean
//   size() - int
public class MyQueue<T> {
    private Object[] array;      // массив для хранения элементов queue
    private int head;      // head указывает на передний элемент в queue
    private int tail;       // tail часть указывает на последний элемент в queue
    private int capacity;   // максимальная емкость queue
    private int count = 0;      // текущий размер queue

    public MyQueue(int size) {
        array = new Object[size];
        capacity = size;
    }

    public MyQueue() {
        capacity = 10;
        array = new Object[capacity];
    }

    public void push(T data) {
        if (count == capacity - 1) {
            Object[] temp = Arrays.copyOf(array, capacity);
            capacity = (int) (capacity * 1.5);
            array = new Object[capacity];
            System.arraycopy(temp, 0, array, 0, temp.length);
        }
        array[count] = data;
        count++;
    }

    public T peek() {
        if (count == 0) {

            return null;
        }
        return (T) array[0];
    }

    public T pop() {
        if (count == 0) {
            return null;
        }
        T result = (T) array[0];
        System.arraycopy(array, 1, array, 0, count);
        count--;
        return result;
    }

    public void print() {
        System.out.print("\n<-[");
        for (int i = 0; i < count; i++) {
            System.out.print(array[i]);
            if (i != count - 1) {
                System.out.print(", ");
            }
        }

        System.out.print("]");

    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>(5);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        myQueue.push(6);
        System.out.println(myQueue.pop());


        MyQueue<String> strQueue = new MyQueue<>(3);
        strQueue.push("A1");
        strQueue.push("A2");
        strQueue.push("A3");
        strQueue.push("A4");
        strQueue.print();
        System.out.println();
        System.out.println(strQueue.pop());
        strQueue.print();
        strQueue.pop();
        strQueue.pop();
        strQueue.pop();
        strQueue.pop();



    }
}
