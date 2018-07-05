package integer;

import java.util.stream.IntStream;

public class Prime {

    private boolean isPrime(int num) {
        return IntStream.range(2, num)
                .allMatch(x -> (num % x) != 0);
    }

    public long countPrimes(int toNum){
        return IntStream.range(1, toNum)
                .parallel()
                .filter(this::isPrime)
                .count();
    }
}
