package integer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntArrayTest {
    int[] testArray;
    IntArray intArray;

    @Before
    public void setUp() {
        testArray = new int[]{1, 3, 2, 4, 5};
        intArray = new IntArray();
    }

    @Test
    public void sum() {
        assertEquals(15, intArray.sum(testArray));
    }

    @Test
    public void multiple() {
        assertEquals(120, intArray.multiple(testArray));

    }

    @Test
    public void max() {
        assertEquals(5, intArray.max(testArray));

    }

    @Test
    public void min() {
        assertEquals(1, intArray.min(testArray));

    }

    @Test
    public void sortAscendant() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, intArray.sortAscendant(testArray));
    }

    @Test
    public void sortDescendant() {
        Assert.assertArrayEquals(new int[]{5, 4, 3, 2, 1}, intArray.sortDescendant(testArray));
    }
}