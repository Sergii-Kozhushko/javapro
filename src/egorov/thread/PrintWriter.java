/**
 * PrintWriter.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-May-2023 20:44
 */

package egorov.thread;

/*Создайте класс Printer, у которого есть метод print(String message),
        который должен выводить сообщение посимвольно с задержкой в 100 миллисекунд.
        Создайте два потока, каждый из которых вызывает метод print()
        с разными сообщениями. Используйте синхронизированный блок внутри метода print(),
        чтобы гарантировать последовательную печать символов сообщений.*/
public class PrintWriter {
    public static void print(String message) {
        for (int i = 0; i < message.length(); i++) {
            synchronized (PrintWriter.class) {
                System.out.print(message.charAt(i) + "_");
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static void main(String[] args) {
        new ThreadString1("Солнце").start();
        new ThreadString1("Земля").start();
    }

}

class ThreadString1 extends Thread {
    private String message;

    ThreadString1(String message) {
        this.message = message;
    }

    @Override
    public void run() {

            PrintWriter.print(message);


    }
}

