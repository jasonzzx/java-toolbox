package concurrency;

import java.util.concurrent.Phaser;

public class PhaserTest {
    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        phaser.register();
        int currentPhase;

        System.out.println("Phaser Start\n");

        new PhaserThread(phaser, "A").start();
        new PhaserThread(phaser, "B").start();
        new PhaserThread(phaser, "C").start();

        // Wait for all threads to complete phase Zero.
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " Completed\n");

        // Wait for all threads to complete phase One.
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " Completed\n");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " Complete\n");

        // Deregister the main thread.
        phaser.arriveAndDeregister();
        if (phaser.isTerminated()) {
            System.out.println("Phaser is terminated");
        }
    }
}

// A thread of execution that uses a Phaser.
class PhaserThread extends Thread {
    Phaser phaser;
    String name;

    public PhaserThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    @Override
    public void run(){
        try {
            System.out.println("Thread: " + name + " Phase 0 Started");
            phaser.arriveAndAwaitAdvance();

            Thread.sleep(10);

            System.out.println("Thread: " + name + " Phase 1 Started");
            phaser.arriveAndAwaitAdvance();

            Thread.sleep(10);

            System.out.println("Thread: " + name + " Phase 2 Started");
            phaser.arriveAndDeregister();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


