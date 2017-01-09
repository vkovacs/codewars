package hu.crs.codewars.didyoumean;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KataTest {

    @Test
    public void testBerries() {
        Kata kata = new Kata(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
        assertEquals("strawberry", kata.findMostSimilar("strawbery"));
        assertEquals("cherry", kata.findMostSimilar("berry"));
    }

    @Test
    public void testLanguages() {
        Kata kata = new Kata(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
        assertEquals("java", kata.findMostSimilar("heaven"));
        assertEquals("javascript", kata.findMostSimilar("javascript"));
    }
}
