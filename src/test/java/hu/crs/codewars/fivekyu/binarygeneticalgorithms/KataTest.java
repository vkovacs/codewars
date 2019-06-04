package hu.crs.codewars.fivekyu.binarygeneticalgorithms;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class KataTest {

    private Kata kata;

    @Before
    public void setUp() throws Exception {
        kata = new Kata();
    }

    @Test
    public void generate() {
        final int length = 10;
        String generated = kata.generate(length);
        assertThat(generated, notNullValue());
        assertThat(generated.length(), is(length));

        int count0s = (int) generated.chars().filter(ch -> ch == '0').count();
        int count1s = (int) generated.chars().filter(ch -> ch == '1').count();
        assertThat(count0s + count1s, is(length));
    }

    @Test
    public void generateIsRandom() {
        final int length = 100_000;

        String a = kata.generate(length);
        String b = kata.generate(length);

        assertThat(a, notNullValue());
        assertThat(b, notNullValue());
        assertThat(a, is(not(b)));
    }
}