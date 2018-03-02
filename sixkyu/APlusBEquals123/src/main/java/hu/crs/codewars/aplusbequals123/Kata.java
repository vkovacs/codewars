package hu.crs.codewars.aplusbequals123;

public class Kata {
    public static long int123(final int a) {
        long overflowZero = (long)Integer.MAX_VALUE * 2 + 2;
        if (a < 123) {
            return overflowZero + (123 - a);
        }
        return overflowZero - (a - 123);
    }
}
