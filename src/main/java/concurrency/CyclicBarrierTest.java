package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) throws Exception {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);

        for (int i = 0; i < N; i++) {
            new CyclicBarrierThread(barrier, i * 1000).start();
            Thread.sleep(1000);
        }

        Thread.sleep(10000);

        System.out.println("\nCyclicBarrier can be reused. So restart same process now.\n");

        for (int i = 0; i < N; i++) {
            new CyclicBarrierThread(barrier, i * 1000).start();
            Thread.sleep(1000);
        }
    }

    static class CyclicBarrierThread extends Thread {
        private CyclicBarrier cyclicBarrier;
        private int sleepMillSec;

        public CyclicBarrierThread(CyclicBarrier cyclicBarrier, int sleepMillSec) {
            this.cyclicBarrier = cyclicBarrier;
            this.sleepMillSec = sleepMillSec;
        }

        @Override
        public void run() {
            System.out.println("Thread (" + Thread.currentThread().getName() + ") is running job...");
            try {
                Thread.sleep(sleepMillSec);
                System.out.println("Thread (" + Thread.currentThread().getName() + ") job is done, waiting for other threads.");

                cyclicBarrier.await();

                System.out.println("(" + Thread.currentThread().getName() + ") I know all Threads(include me) completed. Time to continue my next job");
                Thread.sleep(1000);
                System.out.println("(" + Thread.currentThread().getName() + ") My next job done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
