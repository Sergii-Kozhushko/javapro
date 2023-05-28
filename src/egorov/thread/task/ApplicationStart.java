/**
 * ApplicationStart.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 28-May-2023 00:15
 */

package egorov.thread.task;

import egorov.thread.TaskList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*Создайте класс Task, у которого есть метод execute(),
        который выполняет задачу в течение некоторого времени.
        Создайте пул из пяти потоков и очередь задач. Каждый поток
        должен брать задачу из очереди и выполнять ее.
        Используйте синхронизированный блок и методы wait()
        и notify() для синхронизации доступа к очереди задач.*/

public class ApplicationStart {
   public static void main(String[] args) throws InterruptedException {
      TaskList taskList = new TaskList();
      for (int i = 0; i < 5; i++) {
         Thread thread = new Thread(new TaskHandler(taskList));
         thread.start();
      }
      new Thread(new TaskProducer(taskList)).start();
   }

}

