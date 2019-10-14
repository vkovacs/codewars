package hu.crs.codewars.threekyu.findntgdigit;

import org.junit.Test;

import static hu.crs.codewars.threekyu.findntgdigit.Kata.findDigit;
import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void basicTest() {
        for (int i = 0; i < 30; i++) {// Testing for 0 to 29 digits
            assertEquals("272619325597593231536305887388".charAt(i) - '0', findDigit(i));
        }

        assertEquals(1, findDigit(1000));
        assertEquals(4, findDigit(10000));
        assertEquals(4, findDigit(100000));
        assertEquals(5, findDigit(1000000));
//        assertEquals(3, findDigit(10000000));
//        assertEquals(9, findDigit(100000000));
//        assertEquals(1, findDigit(1000000000));
    }
}