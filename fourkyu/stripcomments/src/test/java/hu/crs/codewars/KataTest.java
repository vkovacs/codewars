package hu.crs.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class KataTest {

    @Test
    @Ignore
    public void stripComments() throws Exception {
        assertEquals(
                "apples, pears\ngrapes\nbananas",
                Kata.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
        );

        assertEquals(
                "a\nc\nd",
                Kata.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
        );

    }
}
