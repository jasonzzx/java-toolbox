package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Exchanger;

import static java.util.concurrent.CompletableFuture.runAsync;

public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Runnable taskA = () -> {
            try {
                String message = exchanger.exchange("from A");
                System.out.println("I am A, I got message " + message);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable taskB = () -> {
            try {
                String message = exchanger.exchange("from B");
                System.out.println("I am B, I got message " + message);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        CompletableFuture.allOf(runAsync(taskA), runAsync(taskB)).join();
    }
}
