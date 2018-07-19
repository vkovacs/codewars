package hu.crs.codewars.sixkyu.persistencebugger;

/**
 * Persistent Bugger.
 *
 * https://www.codewars.com/kata/persistent-bugger
 */
public class Kata {
    public static int persistence(long n) {
        int step = 0;
        while (n > 9) {
            n = multiplyDigits(n);
            step++;
        }
        return step;
    }

    private static long multiplyDigits(long n) {
        int product = 1;
        while (n != 0) {
            product *= n % 10;
            n = n / 10;
        }
        return product;
    }
}
