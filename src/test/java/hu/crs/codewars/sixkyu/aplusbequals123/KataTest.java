package hu.crs.codewars.sixkyu.aplusbequals123;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KataTest {

    private void doIntTest(final int a) {
        final long b = Kata.int123(a);
        int result = (int) (a + b);
        System.out.println("Result: " + result);
        System.out.println("" + a + " + " + b + " = " + result);
        assertTrue(b >= 0);
        assertEquals(123, result);
    }

    @Test
    public void testLess() {
        doIntTest(0);
    }

    @Test
    public void testSame() {
        doIntTest(123);
    }

    @Test
    public void testGreater() {
        doIntTest(500);
    }

    @Test
    public void testMin() {
        doIntTest(-2147483648);
    }
}
