package hu.crs.codewars.threekyu.findntgdigit;

import org.junit.Ignore;
import org.junit.Test;

import static hu.crs.codewars.threekyu.findntgdigit.Kata.findDigit;
import static hu.crs.codewars.threekyu.findntgdigit.Kata.generateFirstLine;
import static hu.crs.codewars.threekyu.findntgdigit.Kata.generateSecondLine;
import static hu.crs.codewars.threekyu.findntgdigit.Kata.sum;
import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
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
    public void generate1LengthFirstLine() {
        assertEquals("1", generateFirstLine(0));
    }

    @Test
    public void generate2LengthFirstLine() {
        assertEquals("12", generateFirstLine(1));
    }

    @Test
    public void generate3LengthFirstLine() {
        assertEquals("123", generateFirstLine(2));
    }

    @Test
    public void generate10LengthFirstLine() {
        assertEquals("1234567891", generateFirstLine(9));
    }

    @Test
    public void generate1LengthSecondLine() {
        assertEquals("1", generateSecondLine(generateFirstLine(0), 0));
    }

    @Test
    public void generate2LengthSecondLine() {
        assertEquals("14", generateSecondLine(generateFirstLine(1), 1));
    }

    @Test
    public void generate10LengthSecondLine() {
        assertEquals("1491625364", generateSecondLine(generateFirstLine(9), 9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sumFirstParametersMustNotBeNull() {
        sum(null, "1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void sumSecondParametersMustNotBeNull() {
        sum("1", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sumSecondParametersMustHaveSameLength() {
        sum("1", "12");
    }

    @Test
    public void sumWithoutCarry() {
        assertEquals("2", sum("1", "1"));
    }

    @Test
    public void sumWithCarry() {
        assertEquals("198", sum("99", "99"));
    }
}