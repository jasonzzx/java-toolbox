package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.runAsync;

public class NewThread {

    public static void main(String[] args) throws Exception {
        Thread threadExtend = new ThreadExtend();
        Thread threadImplRunnable = new Thread(new ThreadImplRunnable());
        Thread threadArrowRunnable = new Thread(() -> System.out.println("Thread implements Runnable with Arrow Function"));

        FutureTask<String> futureTask = new FutureTask<>(()->{
            System.out.println("Thread implements Callable");
            return "Done";
        });
        Thread threadImplCallable = new Thread(futureTask);

        // Method 1: extends Thread
        threadExtend.start();

        // Method 2: implement Runnable
        threadImplRunnable.start();

        // Method 3: implement Runnable with arrow function
        threadArrowRunnable.start();

        // Method 4: Use FutureTask, implement Callable
        threadImplCallable.start();

        System.out.println(futureTask.get());

        // Method 5: CompletableFuture and supplyAsync()
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Future 1 Done";
        }).completeOnTimeout("Empty Value on timeout", 1000, TimeUnit.MILLISECONDS);

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Future 2 Done";
        }).completeOnTimeout("Empty Value on timeout", 1000, TimeUnit.MILLISECONDS);

        System.out.println(
                Stream.of(completableFuture1, completableFuture2)
                        .map(CompletableFuture::join)
                        .collect(Collectors.joining(" ; "))
        );

        // Method 5 CompletableFuture and runAsync()
        Runnable taskA = () -> System.out.println("I am A thread");
        Runnable taskB = () -> System.out.println("I am B thread");
        CompletableFuture.allOf(runAsync(taskA), runAsync(taskB)).join();
    }
}

class ThreadExtend extends Thread {
    @Override
    public void run() {
        System.out.println("Thread extends Thread");
    }
}

class ThreadImplRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread implements Runnable");
    }
}

class ThreadImplCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Thread implements Callable");
        return "Thread Callable Done";
    }
}
