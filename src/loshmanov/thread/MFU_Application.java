/**
 * MFU.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 02-Jun-2023 08:57
 */

package loshmanov.thread;
/*Написать класс МФУ, на котором возможны одновременная печать
        и сканирование документов, при этом нельзя одновременно печатать
        два документа или сканировать (при печати в консоль выводится сообщения
        "отпечатано 1, 2, 3,… страницы", при сканировании тоже самое только
        "отсканировано…", вывод в консоль все также с периодом в 50 мс.)*/
public class MFU_Application {
   public static void main(String[] args) {
      MFU mfu = new MFU();
      new Thread(()->{
         while (!Thread.interrupted()) {
            //synchronized (mfu) {
               mfu.printDocument();
            //}
               try {
                  Thread.sleep(100);
               } catch (InterruptedException e) {
                  throw new RuntimeException(e);
               }

         }

      }).start();
      new Thread(()->{
         while (!Thread.interrupted()) {
            synchronized (mfu) {
               mfu.scanDocument();
            }
               try {
                  Thread.sleep(50);
               } catch (InterruptedException e) {
                  throw new RuntimeException(e);
               }

         }

      }).start();

   }

}
class MFU {
   private static int docsPrinted = 0;
   private static int docsScanned = 0;

   public void printDocument(){
      System.out.println("Printing document #" + docsPrinted++);

   }
   public void scanDocument(){
      System.out.println("Scanning document #" + docsScanned++);
   }

}
