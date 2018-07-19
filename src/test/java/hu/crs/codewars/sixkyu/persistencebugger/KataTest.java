package hu.crs.codewars.sixkyu.persistencebugger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals(3, Kata.persistence(39));
        assertEquals(0, Kata.persistence(4));
        assertEquals(2, Kata.persistence(25));
        assertEquals(4, Kata.persistence(999));
    }
}
