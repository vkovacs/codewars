package hu.crs.codewars.fourkyu.romannumeralsencoder;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataTest {
    private final Kata conversion = new Kata();

    @Test
    public void shouldCovertToRoman() {
        assertEquals("I", conversion.solution(1));
        assertEquals( "IV", conversion.solution(4));
        assertEquals( "VI", conversion.solution(6));
        assertEquals("MMM", conversion.solution(3000));
        assertEquals("MMDCCC", conversion.solution(2800));
        assertEquals("MMCM", conversion.solution(2900));
        assertEquals("MMCD", conversion.solution(2400));
        assertEquals("XCI", conversion.solution(91));
    }
}
