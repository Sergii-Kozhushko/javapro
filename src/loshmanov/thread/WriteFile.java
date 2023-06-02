/**
 * WriteFile.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 02-Jun-2023 07:47
 */

package loshmanov.thread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
Написать совсем небольшой метод, в котором 3 потока построчно
        пишут данные в файл (штук по 10 записей, с периодом в 20 мс)
*/
public class WriteFile {
    private static final int NUM_THREADS = 3;
    public static void main(String[] args) {
        File file = new File("notes.txt");
        Thread[] threads = new Thread[NUM_THREADS];
        try (FileWriter writer = new FileWriter(file, true);) {
            for (int i = 0; i < NUM_THREADS; i++) {
                threads[i] = new Thread(() -> {
                    try {
                        synchronized (writer) {
                            for (int j = 0; j < 10; j++) {
                                writer.write(Thread.currentThread().getName() + " " + j + "\n");
                                Thread.sleep(200);
                            }
                            writer.flush();
                        }
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
                threads[i].start();
            }
            // ждем выполнения всех потоков. Иначе поток выполнится и попытается закрыть поток записи из блока трай виз ресорсес
            for (int i = 0; i < NUM_THREADS; i++) {
                    threads[i].join();
            }
            System.out.println("Finished writing data to file");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

