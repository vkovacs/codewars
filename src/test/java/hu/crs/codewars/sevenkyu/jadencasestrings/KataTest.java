package hu.crs.codewars.sevenkyu.jadencasestrings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class KataTest {
    Kata kata = new Kata();

    @Test
    public void test() {
        assertEquals("toJadenCase doesn't return a valide JadenCase String! try again please :)", "Most Trees Are Blue", kata.toJadenCase("most trees are blue"));
    }

    @Test
    public void testNullArg() {
        assertNull("Must return null when the arg is null", kata.toJadenCase(null));
    }

    @Test
    public void testEmptyArg() {
        assertNull("Must return null when the arg is null", kata.toJadenCase(""));
    }
}
