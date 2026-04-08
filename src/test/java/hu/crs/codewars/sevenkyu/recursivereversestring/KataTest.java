package hu.crs.codewars.sevenkyu.recursivereversestring;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataTest {

    private final Kata kata = new Kata();
    @Test

    public void testSomething1() {
        assertEquals("dlrow olleh", kata.reverse("hello world"));
    }

    @Test
    public void testSomething2() {
        assertEquals("dcba", kata.reverse("abcd"));
    }

    @Test
    public void testSomething3() {
        assertEquals("54321", kata.reverse("12345"));
    }
}
