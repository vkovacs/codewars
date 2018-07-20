package hu.crs.codewars.fivekyu.powersumdig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Numbers that are a power of their sum of digits
 *
 * https://www.codewars.com/kata/55f4e56315a375c1ed000159/train/java
 */
public class Kata {
    private static final int MAX_POWER = 50;
    private static final long MAX_NUMBER_TO_CHECK = 500;
	private static final Map<Integer, Long> resultMap = new HashMap<>();

    public static long powerSumDigTerm(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }

		if (resultMap.get(n) != null) {
			return resultMap.get(n);
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

		for (int i = 0; i < resultList.size(); i++) {
			resultMap.put(i + 1, resultList.get(i));
		}

        return resultMap.get(n);
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
