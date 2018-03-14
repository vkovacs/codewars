package hu.crs.codewars.sixkyu.sumsquareddivisors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void test1() {
        assertEquals("[[1, 1], [42, 2500], [246, 84100]]", Kata.listSquared(1, 250));
    }
    @Test
    public void test2() {
        assertEquals("[[42, 2500], [246, 84100]]", Kata.listSquared(42, 250));
    }
    @Test
    public void test3() {
        assertEquals("[[287, 84100]]", Kata.listSquared(250, 500));
    }
}
