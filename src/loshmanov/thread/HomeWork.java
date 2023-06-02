/**
 * HomeWork.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 02-Jun-2023 07:19
 */

package loshmanov.thread;

/*1. Создать три потока, каждый из которых выводит определенную букву (A, B и C)
        5 раз, порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.*/
public class HomeWork {
    public static void main(String[] args) {
        Integer commonObj = 1;
        Common common = new Common();
        //Thread threadA = new Thread(new ThreadA(commonObj));
        Thread threadA = new Thread(new MyThread(common));
        threadA.setName("A");
        threadA.start();
        //Thread threadB = new Thread(new ThreadB(commonObj));
        Thread threadB = new Thread(new MyThread(common));
        threadB.setName("B");
        threadB.start();
        //Thread threadC = new Thread(new ThreadC(commonObj));
        Thread threadC = new Thread(new MyThread(common));
        threadC.setName("C");
        threadC.start();
    }
}


class MyThread implements Runnable {
    Common commonObj;
    private static int counter;

    public MyThread(Common commonObj) {
        this.commonObj = commonObj;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            if (counter == 100) {
                return;
            }
            synchronized (commonObj) {
                int divider = 0;
                if (Thread.currentThread().getName().equals("A")) {
                    divider = 1;
                }
                if (Thread.currentThread().getName().equals("B")) {
                    divider = 2;
                }

                if (commonObj.value % 3 == divider) {
                    System.out.print(Thread.currentThread().getName());
                    counter++;
                    commonObj.value++;
                    commonObj.notifyAll();
                } else {
                    try {
                        commonObj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}


class Common {
    int value = 1;
}