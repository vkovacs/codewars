package hu.crs.codewars.sevenkyu.recursivereversestring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {

    private Kata kata = new Kata();
    @Test

    public void testSomething1() {
        assertEquals(kata.reverse("hello world"), "dlrow olleh");
    }

    @Test
    public void testSomething2() {
        assertEquals(kata.reverse("abcd"), "dcba");
    }

    @Test
    public void testSomething3() {
        assertEquals(kata.reverse("12345"), "54321");
    }
}
