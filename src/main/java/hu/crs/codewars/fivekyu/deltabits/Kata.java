package hu.crs.codewars.fivekyu.deltabits;

/**
 * Delta bits
 *
 * https://www.codewars.com/kata/538948d4daea7dc4d200023f/train/java
 */
public class Kata {

    public static int convertBits(int a, int b) {
        return Integer.bitCount(a ^ b);
    }
}
