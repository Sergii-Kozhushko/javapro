/**
 * HomeWorkThreads6.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-May-2023 20:20
 */

package egorov.thread;

/*
Создайте класс Counter, который имеет внутреннее целочисленное поле count.
        Создайте два потока, каждый из которых увеличивает count на 1 миллион раз.
        Используйте синхронизированный блок, чтобы гарантировать
        корректное обновление значения count
*/
public class HomeWorkThreads6 {
    public static void main(String[] args) {
        new ThreadC1().start();
        new ThreadC2().start();
    }

}

class Counter {
    static int value = 0;
}

class ThreadC1 extends Thread {
    @Override
    public void run() {
        synchronized (Counter.class) {
            for (int i = 0; i < 1_000_000; i++) {
                Counter.value++;
            }
            System.out.println(this.getName() + " " + Counter.value);
        }

    }
}
class ThreadC2 extends Thread {
    @Override
    public void run() {
        synchronized (Counter.class) {
            for (int i = 0; i < 1_000_000; i++) {
                Counter.value++;
            }
            System.out.println(this.getName() + " " + Counter.value);
        }

    }
}
