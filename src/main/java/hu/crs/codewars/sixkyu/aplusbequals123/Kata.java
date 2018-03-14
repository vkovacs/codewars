package hu.crs.codewars.sixkyu.aplusbequals123;

/**
 * A + B == 123
 *
 * http://www.codewars.com/kata/a-plus-b-equals-equals-123/
 */
public class Kata {
    public static long int123(final int a) {
        long overflowZero = (long)Integer.MAX_VALUE * 2 + 2;
        if (a < 123) {
            return overflowZero + (123 - a);
        }
        return overflowZero - (a - 123);
    }
}
