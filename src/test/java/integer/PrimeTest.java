package integer;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeTest {
    int countTo = 100000;
    private Prime prime = new Prime();

    @Test
    public void countNormalPrimes() {
        assertEquals(9593, prime.countPrimes(countTo));
    }

    @Test
    public void countOnePrimes() {
        assertEquals(0, prime.countPrimes(1));
    }

    @Test
    public void countTwoPrimes() {
        assertEquals(1, prime.countPrimes(2));
    }
}