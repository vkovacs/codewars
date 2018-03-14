package hu.crs.codewars.fourkyu.validbraces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {

    private Kata checker = new Kata();

    @Test
    public void testValid() {
        assertEquals(true, checker.isValid("()"));
    }

    @Test
    public void testInvalid0() {
        assertEquals(false, checker.isValid("[(])"));
    }

    @Test
    public void testInvalid1() {
        assertEquals(false, checker.isValid("(((({{"));
    }
}
