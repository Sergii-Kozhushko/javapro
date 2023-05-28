/**
 * TaskHandler.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 28-May-2023 00:22
 */

package egorov.thread.task;

import egorov.thread.TaskList;


public class TaskHandler implements Runnable {
    private TaskList taskList;

    public TaskHandler(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void run() {
        boolean processTasks = true;

        while (true) {
            Task task = null;
            synchronized (taskList) {
                while (task == null) {
                    try {
                        taskList.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    task = taskList.getAnyUnfinishedTask();
                }
                taskList.executeTask(task);
                System.out.print(Thread.currentThread().getName() + " completed task " +
                        task.toString() + ". " + taskList.getStatistics());
            }
        }
    }
}
