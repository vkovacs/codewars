package hu.crs.codewars.fivekyu.deltabits;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class KataTest {
    @Test
    public void test() throws Exception {
        assertThat(Kata.convertBits(31, 14), is(2));
    }
}
