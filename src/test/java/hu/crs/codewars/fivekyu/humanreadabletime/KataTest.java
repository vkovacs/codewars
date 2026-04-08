package hu.crs.codewars.fivekyu.humanreadabletime;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataTest {

    @Test
    public void Tests() {
        assertEquals("00:00:00", Kata.makeReadable(0));
        assertEquals("00:00:05", Kata.makeReadable(5));
        assertEquals("00:01:00", Kata.makeReadable(60));
        assertEquals("23:59:59", Kata.makeReadable(86399));
        assertEquals("99:59:59", Kata.makeReadable(359999));
    }
}
