package concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFutureTest test = new CompletableFutureTest();
 
        Instant start = Instant.now();
        int result = test.getTwo() + test.getThree();
        Instant end = Instant.now();
 
        System.out.println("Elapsed Time: " + Duration.between(start, end).toSeconds() + " Seconds");
        System.out.println(result);
 
        Instant start2 = Instant.now();
        int result2 = Stream.of(CompletableFuture.supplyAsync(() -> test.getTwo()),  CompletableFuture.supplyAsync(() -> test.getThree()))
                .mapToInt(CompletableFuture::join)
                .sum();
        Instant end2 = Instant.now();
 
        System.out.println("Elapsed Time: " + Duration.between(start2, end2).toSeconds() + " Seconds");
        System.out.println(result2);
    }
 
 
    int getTwo(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2;
    }
 
    int getThree(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 3;
    }
}
