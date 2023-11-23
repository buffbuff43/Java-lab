package org.example;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;



public class Main {
    static final int CARS_COUNT = 6;
    public static final int TUNNEL_CONSTRAINT = 3;
    public static final AtomicInteger finishCount = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT+1);
        CyclicBarrier cb2 = new CyclicBarrier(CARS_COUNT+1);
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 200 + (int) (Math.random() * 5), cb, cb2);
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        try {
            cb.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cb2.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            Car.printWinners();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}