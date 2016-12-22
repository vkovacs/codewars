package hu.crs.codewars.findmissingletter;

import static org.junit.Assert.assertEquals;

import hu.crs.codewars.findmissingletter.Kata;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void exampleTests() {
        assertEquals('e', Kata.findMissingLetter(new char[] { 'a', 'b', 'c', 'd', 'f' }));
        assertEquals('P', Kata.findMissingLetter(new char[] { 'O', 'Q', 'R', 'S' }));
    }
}

