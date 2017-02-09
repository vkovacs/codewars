package hu.crs.codewars.scramblies;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    private static void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests scramble");
        testing(Kata.scramble("rkqodlw","world"), true);
        testing(Kata.scramble("cedewaraaossoqqyt","codewars"),true);
        testing(Kata.scramble("katas","steak"),false);
        testing(Kata.scramble("scriptjavx","javascript"),false);
        testing(Kata.scramble("scriptingjava","javascript"),true);
        testing(Kata.scramble("scriptsjava","javascripts"),true);
        testing(Kata.scramble("javscripts","javascript"),false);
        testing(Kata.scramble("aabbcamaomsccdd","commas"),true);
        testing(Kata.scramble("commas","commas"),true);
        testing(Kata.scramble("sammoc","commas"),true);
    }
}
