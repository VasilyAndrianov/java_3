package lesson_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private CyclicBarrier barrier;
    private Object referee;
    private Race race;
    private int speed;
    private String name;

    static {
        CARS_COUNT = 0;
    }


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Object referee, CyclicBarrier barrier, Race race, int speed) {
        this.race =  race;
        this.speed =  speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.barrier =  barrier;
        this.referee =  referee;
    }

    @Override
    public  void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500  + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            barrier.await();
            barrier.await();
        } catch( Exception e) {
            e.printStackTrace();
        }
        for(int i =  0; i <  race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        //проверка победы
        synchronized (referee) {
            if(MainClass.WIN_COUNT > 0) {
                System.out.println(this.name + " Занял " + ++MainClass.WIN + " место.");
                MainClass.WIN_COUNT--;
            }
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


}