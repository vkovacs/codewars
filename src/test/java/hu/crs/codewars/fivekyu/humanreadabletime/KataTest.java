package hu.crs.codewars.fivekyu.humanreadabletime;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {

    @Test
    public void Tests() {
        assertEquals("makeReadable(0)", "00:00:00", Kata.makeReadable(0));
        assertEquals("makeReadable(5)", "00:00:05", Kata.makeReadable(5));
        assertEquals("makeReadable(60)", "00:01:00", Kata.makeReadable(60));
        assertEquals("makeReadable(86399)", "23:59:59", Kata.makeReadable(86399));
        assertEquals("makeReadable(359999)", "99:59:59", Kata.makeReadable(359999));
    }
}
