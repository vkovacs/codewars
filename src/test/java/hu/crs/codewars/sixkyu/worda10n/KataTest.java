package hu.crs.codewars.sixkyu.worda10n;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void testInternationalization() {
        assertEquals("i18n", Kata.abbreviate("internationalization"));
    }
}
