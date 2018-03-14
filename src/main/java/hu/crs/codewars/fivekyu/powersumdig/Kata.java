package hu.crs.codewars.fivekyu.powersumdig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Numbers that are a power of their sum of digits
 *
 * https://www.codewars.com/kata/55f4e56315a375c1ed000159/train/java
 */
public class Kata {
    private static final int MAX_POWER = 50;
    private static final long MAX_NUMBER_TO_CHECK = 500;

    public static long powerSumDigTerm(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }

        List<Long> resultList = new ArrayList<>();

        for (int i = 2; i < MAX_NUMBER_TO_CHECK; i++) {
            for (int j=2; j < MAX_POWER; j++) {
                long product = (long) Math.pow(i, j);
                if (sumOfDigits(product) == i) {
                    resultList.add(product);
                }
            }
        }
        Collections.sort(resultList);

        return resultList.get(n - 1);
    }

    private static long sumOfDigits(long number) {
        long sumOfDigits = 0;
        while (number > 0) {
            sumOfDigits = sumOfDigits + number % 10;
            number = number / 10;
        }
        return sumOfDigits;
    }
}
