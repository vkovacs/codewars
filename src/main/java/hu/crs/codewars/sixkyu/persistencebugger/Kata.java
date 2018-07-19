package hu.crs.codewars.sixkyu.persistencebugger;

/**
 * Persistent Bugger.
 *
 * https://www.codewars.com/kata/persistent-bugger
 */
public class Kata {
    public static int persistence(int i) {
        int step = 0;
        while (i > 9) {
            i = multiplyDigits(i);
            step++;
        }
        return step;
    }

    private static int multiplyDigits(int i) {
        int product = 1;
        while (i != 0) {
            product *= i % 10;
            i = i / 10;
        }

        return product;
    }
}
