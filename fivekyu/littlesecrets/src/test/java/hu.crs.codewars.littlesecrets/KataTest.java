package hu.crs.codewars.littlesecrets;

import org.junit.Assert;
import org.junit.Test;

public class KataTest {

    @Test
    public void valid() throws NoSuchFieldException, IllegalAccessException {
        Assert.assertEquals("netVeryWellProtected",Kata.guess("secret"));
    }

    @Test(expected = NoSuchFieldException.class)
    public void exception() throws NoSuchFieldException, IllegalAccessException {
        Assert.assertEquals("netVeryWellProtected",Kata.guess("nosuchfields"));
    }
}
