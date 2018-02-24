package string;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringOperationTest {

    @Test
    public void distinctSort() {
        StringOperation stringOperation = new StringOperation();
        String actual = stringOperation.distinctSort("FFFEEEDDCCBBA");
        assertEquals("ABCDEF", actual);
    }
}