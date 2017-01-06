package hu.crs.codewars.trailingzeros;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class KataTest {
    @Test
    public void testZeros() throws Exception {
        assertThat(Kata.zeros(0), is(0));
        assertThat(Kata.zeros(6), is(1));
        assertThat(Kata.zeros(14), is(2));
        assertThat(Kata.zeros(32), is(7));
    }
}
