package hu.crs.codewars.emirps;

import org.junit.Assert;
import org.junit.Test;

public class KataTest {
    @Test
    public void testSomething() {
        Assert.assertArrayEquals(new long [] {0, 0, 0}, Kata.findEmirp(10));
        Assert.assertArrayEquals(new long [] {4, 37, 98}, Kata.findEmirp(50));
        Assert.assertArrayEquals(new long [] {8, 97, 418}, Kata.findEmirp(100));
        Assert.assertArrayEquals(new long [] {446, 14957, 3661772}, Kata.findEmirp(14958));
    }


}
