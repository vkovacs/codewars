package hu.crs.codewars.sixkyu.worda10n;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataTest {
    @Test
    public void testInternationalization() {
        assertEquals("i18n", Kata.abbreviate("internationalization"));
    }
}
