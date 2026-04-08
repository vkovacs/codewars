package hu.crs.codewars.sixkyu.findmissingletter;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataTest {
    @Test
    public void exampleTests() {
        assertEquals('e', Kata.findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
        assertEquals('P', Kata.findMissingLetter(new char[]{'O', 'Q', 'R', 'S'}));
    }

    @Test
    public void invalidTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Kata.findMissingLetter(new char[]{'a', 'b'}));

    }
}

