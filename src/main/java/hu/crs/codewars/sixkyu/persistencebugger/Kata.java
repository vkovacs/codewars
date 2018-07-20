package hu.crs.codewars.sixkyu.persistencebugger;

import java.util.Arrays;

/**
 * Persistent Bugger.
 *
 * https://www.codewars.com/kata/persistent-bugger
 */
public class Kata {
    public static int persistence(long n) {
        long digitProduct = n;
        if (digitProduct < 10) return 0;

        digitProduct = multiplyDigits(digitProduct);
        int step = 1;
        while (digitProduct > 9) {
            digitProduct = multiplyDigits(digitProduct);
            step++;
        }
        return step;
    }

    private static long multiplyDigits(long digitProduct) {
        return Arrays.stream(String.valueOf(digitProduct).split(""))
                .mapToLong(Long::valueOf)
                .reduce((a1, b1) -> a1 * b1)
                .orElseThrow(IllegalArgumentException::new);
    }
}


