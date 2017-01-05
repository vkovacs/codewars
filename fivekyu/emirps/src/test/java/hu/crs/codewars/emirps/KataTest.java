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
        Assert.assertArrayEquals(new long [] {2205, 119993, 137429553}, Kata.findEmirp(119994));
        Assert.assertArrayEquals(new long [] {2330, 124777, 152727598}, Kata.findEmirp(124778));
    }


}
