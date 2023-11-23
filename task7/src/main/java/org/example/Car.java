package org.example;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;


public class Car implements Runnable {

    private static int CARS_COUNT;
    private static final int MAX_WINNERS=3;
    private static final Car[] winners = new Car[MAX_WINNERS];
    private static final Object lock = new Object();

    static {
        CARS_COUNT = 0;
    }

    private CyclicBarrier cb;
    private CyclicBarrier cb2;
    private Race race;
    private int speed;
    private String name;
    private AtomicInteger stagesCompleted = new AtomicInteger(0);
    private static boolean winnerFound = false;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }


    public Car(Race race, int speed, CyclicBarrier cb, CyclicBarrier cb2) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cb;
        this.cb2 = cb2;
    }

    @Override
    public void run() {
        Thread carThread = new Thread(() -> {
            try {
                System.out.println(this.name + " готовится");
                Thread.sleep(500 + (int) (Math.random() * 800));
                System.out.println(this.name + " готов");
                cb.await();
                for (int i = 0; i < race.getStages().size(); i++) {
                    Stage currentStage = race.getStages().get(i);
                    currentStage.go(this);
                    stagesCompleted.incrementAndGet();
                }
                CheckWin(this);
                cb2.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        carThread.start();
    }

    private static void CheckWin(Car car) {
        synchronized (lock) {
            if (!winnerFound) {
                for (int i = 0; i < MAX_WINNERS; i++) {
                    if (winners[i] == null) {
                        winners[i] = car;
                        break;
                    }
                }
                if (winners[MAX_WINNERS - 1] != null) {
                    winnerFound = true;
                }
            }
        }
    }

    public static void printWinners() {
        System.out.println("ПОБЕДИТЕЛИ");
        for (int i = 0; i < 3; i++) {
            if (winners[i] != null) {
                System.out.println((i + 1) + " МЕСТО: " + winners[i].getName());
            }
        }
    }
}

