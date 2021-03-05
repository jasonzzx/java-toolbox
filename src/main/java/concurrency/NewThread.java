package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class NewThread {
    public static void main(String[] args) throws Exception{
        Thread threadExtend = new ThreadExtend();
        Thread threadImplRunnable = new Thread(new ThreadImplRunnable());
        Thread threadArrowRunnable = new Thread(() -> System.out.println("Thread implements Runnable with Arrow Function"));

        FutureTask<String> futureTask = new FutureTask<>(new ThreadImplCallable());
        Thread threadImplCallable = new Thread(futureTask);

        threadExtend.start();
        threadImplRunnable.start();
        threadArrowRunnable.start();
        threadImplCallable.start();

        System.out.println(futureTask.get());
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