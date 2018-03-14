package hu.crs.codewars.fivekyu.josephussurvivor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Josephus Survivor
 *
 * https://www.codewars.com/kata/555624b601231dc7a400017a/train/java
 */
public class KataTest {

    @Test
    public void test1() {
        josephusTest(7, 3, 4);
    }

    @Test
    public void test2() {
        josephusTest(11, 19, 10);
    }

    @Test
    public void test3() {
        josephusTest(40, 3, 28);
    }

    @Test
    public void test4() {
        josephusTest(14, 2, 13);
    }

    @Test
    public void test5() {
        josephusTest(100, 1, 100);
    }

    @Test
    public void test6() {
        josephusTest(1, 1, 1);
    }

    @Test
    public void test7() {
        josephusTest(2, 1, 2);
    }

    private void josephusTest(final int n, final int k, final int result) {
        String testDescription = String.format("Testing where n = %d and k = %d", n, k);
        assertEquals(testDescription, result, Kata.josephusSurvivor(n, k));
    }
}
