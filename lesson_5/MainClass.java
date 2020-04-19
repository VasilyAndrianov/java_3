package lesson_5;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS = 7;
    public static final Semaphore SEMAPHORE_TUNNEL = new Semaphore(CARS / 2,true); //ограничение машин в тоннеле
    public static CyclicBarrier barrier=new CyclicBarrier(CARS+1);
    public static int WIN_COUNT = 7;
    public static int WIN = 0;

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS];
        Object referee = new Object();
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(referee,barrier,race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        barrier.await(); //ждем всех участников
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        barrier.await();
        barrier.await(); //ждем пока все финишируют
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}







