package hu.crs.codewars.sevenkyu.jadencasestrings;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class KataTest {
    Kata kata = new Kata();

    @Test
    public void test() {
        assertEquals("Most Trees Are Blue", kata.toJadenCase("most trees are blue"));
    }

    @Test
    public void testNullArg() {
        assertNull(kata.toJadenCase(null), "Must return null when the arg is null");
    }

    @Test
    public void testEmptyArg() {
        assertNull(kata.toJadenCase(""), "Must return null when the arg is null");
    }
}
