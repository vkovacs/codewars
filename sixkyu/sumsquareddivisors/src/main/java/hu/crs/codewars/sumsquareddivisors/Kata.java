package hu.crs.codewars.sumsquareddivisors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kata {

    public static String listSquared(long m, long n) {
        List<long[]> result = new ArrayList<>();

        for (long l = m; l <= n; l++) {
            List<Long> divisors = foundDivisors(l);
            long divisorSum = divisors.stream().mapToLong(num -> num * num).sum();
            if (Math.sqrt(divisorSum) % 1 == 0) {
                result.add(new long[]{l, divisorSum});
            }
        }
        return Arrays.deepToString(result.toArray());
    }

    private static List<Long> foundDivisors(long num) {
        List<Long> divisors = new ArrayList<>();
        long max = (long) Math.floor(num / 2);
        for (long l = 1; l <= max; l++) {
            if (num % l == 0) {
                divisors.add(l);
            }
        }

        divisors.add(num);
        return divisors;
    }

}
