package hu.crs.codewars.fivekyu.deltabits;


import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class KataTest {
    @Test
    public void test() throws Exception {
        assertThat(Kata.convertBits(31, 14), is(2));
    }
}
