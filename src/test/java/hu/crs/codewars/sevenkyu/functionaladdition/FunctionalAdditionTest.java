package hu.crs.codewars.sevenkyu.functionaladdition;


import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FunctionalAdditionTest {
    @Test
    public void addOne() {
        assertThat(FunctionalAddition.add(10).apply(1), is(11));
    }
}
