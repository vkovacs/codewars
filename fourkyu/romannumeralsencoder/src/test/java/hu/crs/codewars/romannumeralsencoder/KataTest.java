package hu.crs.codewars.romannumeralsencoder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    private Kata conversion = new Kata();

    @Test
    public void shouldCovertToRoman() {
        assertEquals("solution(1) should equal to I", "I", conversion.solution(1));
        assertEquals("solution(4) should equal to IV", "IV", conversion.solution(4));
        assertEquals("solution(6) should equal to VI", "VI", conversion.solution(6));
        assertEquals("solution(3000) should equal to MMM", "MMM", conversion.solution(3000));
        assertEquals("solution(2800) should equal to MMDCCC", "MMDCCC", conversion.solution(2800));
        assertEquals("solution(2900) should equal to MMCM", "MMCM", conversion.solution(2900));
        assertEquals("solution(2900) should equal to MMCD", "MMCD", conversion.solution(2400));
        assertEquals("solution(91) should equal to XCI", "XCI", conversion.solution(91));
    }
}
