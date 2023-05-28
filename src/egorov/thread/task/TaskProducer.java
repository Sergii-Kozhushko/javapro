/**
 * TaskProducer.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 28-May-2023 14:16
 */

package egorov.thread.task;

import egorov.thread.TaskList;

import java.util.ArrayList;
import java.util.Random;

public class TaskProducer implements Runnable {
    private TaskList taskList;

    public TaskProducer(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter < 1000) {
            int taskNum = new Random().nextInt(10);

            if (taskNum < 5 && taskNum != 0) {

                for (int i = 0; i < taskNum; i++) {
                    synchronized (taskList) {
                        taskList.getTaskList().add(new Task("#" + counter * 10 + i));
                        System.out.print("New task #" + counter * 10 + i + ". " + taskList.getStatistics());
                        taskList.notify();
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter += 1;
        }

    }
}
