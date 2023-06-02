/**
 * FileWriterThreads.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 02-Jun-2023 08:25
 */

package loshmanov.thread;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterThreads {

   private static final String FILE_PATH = "output.txt";
   private static final int NUM_THREADS = 3;
   private static final int NUM_RECORDS = 10;
   private static final int SLEEP_TIME = 20;

   public static void main(String[] args) {
      try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
         Thread[] threads = new Thread[NUM_THREADS];

         for (int i = 0; i < NUM_THREADS; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
               try {
                  synchronized (fileWriter) {
                     for (int j = 0; j < NUM_RECORDS; j++) {
                        String data = "Thread " + threadId + ": Record " + j + "\n";
                        fileWriter.write(data);
                        Thread.sleep(SLEEP_TIME);
                     }
                  }
               } catch (IOException | InterruptedException e) {
                  e.printStackTrace();
               }
            });
            threads[i].start();
         }

         for (Thread thread : threads) {
            thread.join();
         }

         System.out.println("Data has been written to " + FILE_PATH);
      } catch (IOException | InterruptedException e) {
         e.printStackTrace();
      }
   }
}
