package hu.crs.codewars.powersumdig;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MILLIS;

public class Kata {
    public static long powerSumDigTerm(int n) {
        int resultNumberCount = 0;
        long currentNumberToCheck = 10;
        LocalTime previousTime = LocalTime.now();
        while (resultNumberCount <= n) {
            long sumOfDigits = sumOfDigits(currentNumberToCheck);
            if (isProductOf(currentNumberToCheck, sumOfDigits)) {
                resultNumberCount++;
                LocalTime now = LocalTime.now();
                System.out.println(previousTime.until(now, MILLIS) + " " + resultNumberCount + ": " + currentNumberToCheck);
                previousTime = now;

                if (resultNumberCount == n) {
                    return currentNumberToCheck;
                }
            }
            currentNumberToCheck++;
        }
        throw new RuntimeException();
    }

    //for 16th resultNumberCount it's 9.8 sec from 25 sec
    private static long sumOfDigits(long number) {
        long numberOfDigits = 0;
        while (number > 0) {
            numberOfDigits = numberOfDigits + number % 10;
            number = number / 10;
        }
        return numberOfDigits;
    }

    private static boolean isProductOf(long product, long base) {
        if (base == 1) {
            return product == base;
        }
        //increase computation speed for 10+ resultNumberCount
        //eg for 14th it's 3838 ms from 19403 ms
        if ((product % base) != 0) {
            return false;
        }

        long tmpProduct = base;
        //~ -5 sec for computataion speed for 16th resultNumberCount
        while (tmpProduct < product) {
            tmpProduct *= base;
        }

        return tmpProduct == product;
    }
}
