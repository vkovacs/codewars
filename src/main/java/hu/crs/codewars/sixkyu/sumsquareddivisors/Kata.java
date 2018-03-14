package hu.crs.codewars.sixkyu.sumsquareddivisors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Integers: Recreation One
 *
 * https://www.codewars.com/kata/integers-recreation-one/train/java
 */
public class Kata {

    public static String listSquared(long m, long n) {
        List<long[]> result = new ArrayList<>();

        for (long i = m; i <= n; i++) {
            List<Long> divisors = foundDivisors(i);
            long divisorSum = divisors.stream().mapToLong(num -> num * num).sum();
            double sqrt = Math.sqrt(divisorSum);
            if (isInteger(sqrt)) {
                result.add(new long[]{i, divisorSum});
            }
        }
        return Arrays.deepToString(result.toArray());
    }

    private static List<Long> foundDivisors(long num) {
        List<Long> divisors = new ArrayList<>();
        long max = num / 2;
        for (long l = 1; l <= max; l++) {
            if (num % l == 0) {
                divisors.add(l);
            }
        }

        divisors.add(num);
        return divisors;
    }

    private static boolean isInteger(double d) {
        return (int) Math.ceil(d) == (int) Math.floor(d);
    }

}
