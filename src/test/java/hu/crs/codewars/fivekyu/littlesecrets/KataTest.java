package hu.crs.codewars.fivekyu.littlesecrets;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataTest {

    @Test
    public void valid() throws NoSuchFieldException, IllegalAccessException {
        assertEquals("netVeryWellProtected",Kata.guess("secret"));
    }

    @Test
    public void exception() throws NoSuchFieldException, IllegalAccessException {
        Assertions.assertThrows(NoSuchFieldException.class, () -> {
            assertEquals("netVeryWellProtected",Kata.guess("nosuchfields"));
        });

    }
}
