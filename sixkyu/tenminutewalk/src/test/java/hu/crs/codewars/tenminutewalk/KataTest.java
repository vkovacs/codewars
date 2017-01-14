package hu.crs.codewars.tenminutewalk;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void Test() {
        assertEquals("Should return true", true, Kata.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
        assertEquals("Should return false", false, Kata.isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
        assertEquals("Should return false", false, Kata.isValid(new char[] {'w'}));
        assertEquals("Should return false", false, Kata.isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
    }
}
