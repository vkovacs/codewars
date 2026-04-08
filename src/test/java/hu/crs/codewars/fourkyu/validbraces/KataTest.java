package hu.crs.codewars.fourkyu.validbraces;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KataTest {

    private Kata checker = new Kata();

    @Test
    public void testValid() {
        assertTrue(checker.isValid("()"));
    }

    @Test
    public void testInvalid0() {
        assertFalse(checker.isValid("[(])"));
    }

    @Test
    public void testInvalid1() {
        assertFalse(checker.isValid("(((({{"));
    }
}
