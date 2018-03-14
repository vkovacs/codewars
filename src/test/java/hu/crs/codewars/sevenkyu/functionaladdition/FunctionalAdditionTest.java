package hu.crs.codewars.sevenkyu.functionaladdition;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class FunctionalAdditionTest {
    @Test
    public void addOne() {
        Assert.assertThat(FunctionalAddition.add(10).apply(1), is(11));
    }
}
