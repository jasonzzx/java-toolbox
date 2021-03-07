package concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        System.out.println("Main Thread (" + Thread.currentThread().getName() + ") waiting for 2 child threads completed...");

        new Thread(() -> {
            try {
                System.out.println("Child Thread 1 (" + Thread.currentThread().getName() + ") is running");
                Thread.sleep(3000);
                System.out.println("Child Thread 1 (" + Thread.currentThread().getName() + ") is done");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("Child Thread 2 (" + Thread.currentThread().getName() + ") is running");
                Thread.sleep(3000);
                System.out.println("Child Thread 2 (" + Thread.currentThread().getName() + ") is done");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            // Block Here
            latch.await(); // After count down to 2 -> 1 -> 0

            System.out.println("2 Child Threads completed");
            System.out.println("Continue the Main Thread (" + Thread.currentThread().getName() + ")...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
