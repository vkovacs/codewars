package hu.crs.codewars.threekyu.findntgdigit;

import org.junit.Ignore;
import org.junit.Test;

import static hu.crs.codewars.threekyu.findntgdigit.Kata.findDigit;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class KataTest {
    @Test
    @Ignore
    public void basicTest() {
        for (int i = 0; i < 30; i++) {// Testing for 0 to 29 digits
            System.out.println(i);
            assertEquals("272619325597593231536305887388".charAt(i) - '0', findDigit(i));
        }

        assertEquals(1, findDigit(1000));
        assertEquals(4, findDigit(10000));
        assertEquals(4, findDigit(100000));
        assertEquals(5, findDigit(1000000));
        assertEquals(3, findDigit(10000000));
        assertEquals(9, findDigit(100000000));
        assertEquals(1, findDigit(1000000000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void finDigitLengthMustBeGreaterOrEqualsThanZero() {
        findDigit(-1);
    }

    @Test
    public void find0thDigitInFirstLine() {
        assertThat(Kata.nthDigitOfFirstLine(0), is(1));
    }

    @Test
    public void find9thDigitInFirstLine() {
        assertThat(Kata.nthDigitOfFirstLine(9), is(1));
    }

    @Test
    public void find10thDigitInFirstLine() {
        assertThat(Kata.nthDigitOfFirstLine(10), is(0));
    }

    @Test
    public void find0thDigitISecondLine() {
        assertThat(Kata.nthDigitOfSecondLine(0), is(1));
    }

    @Test
    public void find1stDigitISecondLine() {
        assertThat(Kata.nthDigitOfSecondLine(1), is(4));
    }

    @Test
    public void find3rdDigitISecondLine() {
        assertThat(Kata.nthDigitOfSecondLine(3), is(1));
    }

    @Test
    public void find4thDigitISecondLine() {
        assertThat(Kata.nthDigitOfSecondLine(4), is(6));
    }
}