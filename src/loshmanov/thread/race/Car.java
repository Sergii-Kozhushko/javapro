/**
 * Car.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 04-Jun-2023 22:27
 */

package loshmanov.thread.race;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {

    private static int CARS_COUNT = 0;

    private static int placeCount = 1;
    private String name;
    private int speed;
    private Race race;

    private String state = "";

    private CyclicBarrier startPoint;

    public Car(Race race, int speed, CyclicBarrier startPoint) {
        this.race = race;
        this.speed = speed;
        this.startPoint = startPoint;
        CARS_COUNT++;
        this.name = "" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            state = "preparing";
            Thread.sleep((int) (1500 * Math.random() + 500));
            state = "ready";
            startPoint.await();

            state = "started race";
            Thread.sleep(300);
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            state = "took " + placeCount + " place";
            placeCount++;
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
