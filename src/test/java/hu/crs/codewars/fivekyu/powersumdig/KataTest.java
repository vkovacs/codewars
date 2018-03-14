package hu.crs.codewars.fivekyu.powersumdig;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    private static void testing(long act, long exp) {
        assertEquals(exp, act);
    }
    @Test
    public void test1() {
        testing(Kata.powerSumDigTerm(1), 81);
        testing(Kata.powerSumDigTerm(2), 512);
        testing(Kata.powerSumDigTerm(3), 2401);
        testing(Kata.powerSumDigTerm(4), 4913);
    }
}
