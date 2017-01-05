package hu.crs.codewars.largefactorials;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KataTest {

    @Test
    public void BasicTests()
    {
        assertEquals("1", Kata.Factorial(1));
        assertEquals("120", Kata.Factorial(5));
        assertEquals("362880", Kata.Factorial(9));
        assertEquals("1307674368000", Kata.Factorial(15));
    }

}
