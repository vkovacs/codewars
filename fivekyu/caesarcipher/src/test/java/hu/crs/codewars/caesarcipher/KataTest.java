package hu.crs.codewars.caesarcipher;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {

    @Test
    public void test1() {
        String u = "I should have known that you would have a perfect answer for me!!!";
        List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!");
        assertEquals(v, Kata.movingShift(u, 1));
        assertEquals(u, Kata.demovingShift(Kata.movingShift(u, 1), 1));
    }

    @Test
    public void test2() {
        String u = "I should";
        List<String> v = Arrays.asList("J ", "vl", "ta", "sl", "");
        assertEquals(v, Kata.movingShift(u, 1));
        assertEquals(u, Kata.demovingShift(Kata.movingShift(u, 1), 1));
    }

    @Test
    public void test3() {
        String u = "111111111111111111111111111111";
        List<String> v = Arrays.asList("111111", "111111", "111111", "111111", "111111");
        assertEquals(v, Kata.movingShift(u, 1));
        assertEquals(u, Kata.demovingShift(Kata.movingShift(u, 1), 1));
    }
}
