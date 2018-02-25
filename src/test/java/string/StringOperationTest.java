package string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringOperationTest {
    StringOperation stringOperation;

    @Before
    public void setUp() throws Exception {
        stringOperation = new StringOperation();
    }

    @Test
    public void testDistinctSort() {
        String actual = stringOperation.distinctSort("FFFEEEDDCCBBA");
        assertEquals("ABCDEF", actual);
    }

    @Test
    public void testSplitAndRejoin(){
        String actual = stringOperation.splitAndRejoin("JAN,FEB,MAR,APR,MAY,JUN,JUL", ",", "J");
        assertEquals("JAN,JUL,JUN", actual);
    }

}