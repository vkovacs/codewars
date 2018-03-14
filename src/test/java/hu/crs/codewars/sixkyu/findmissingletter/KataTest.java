package hu.crs.codewars.sixkyu.findmissingletter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void exampleTests() {
        assertEquals('e', Kata.findMissingLetter(new char[] { 'a', 'b', 'c', 'd', 'f' }));
        assertEquals('P', Kata.findMissingLetter(new char[] { 'O', 'Q', 'R', 'S' }));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidTest() {
        Kata.findMissingLetter(new char[]{'a', 'b'});
    }
}

