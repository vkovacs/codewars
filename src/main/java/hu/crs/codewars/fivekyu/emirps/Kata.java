package hu.crs.codewars.fivekyu.emirps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Emirps
 *
 * https://www.codewars.com/kata/55de8eabd9bef5205e0000ba/train/java
 */
public class Kata {
    private static final int MAX_NUMBER = 999999;

    private static final boolean[] numbers = new boolean[MAX_NUMBER + 2];

    private static final Set<Integer> primeSet;

    static {
        Arrays.fill(numbers, true);
        primeSet = primes(sievePrimes(numbers));
    }

    public static long[] findEmirp(long n){

        int emirpCount = 0;
        int emirpMax = 0;
        long emirpSum = 0;

        for (Integer prime : primeSet) {
            if (prime < n) {
                if (!isPalindrome(prime)) {
                    if (isReverseAPrime(prime)) {
                        emirpCount++;
                        if (emirpMax < prime) {
                            emirpMax = prime;
                        }

                        emirpSum += prime;
                    }
                }
            }
        }

        return new long[] {emirpCount, emirpMax, emirpSum};
    }

    private static boolean[] sievePrimes(boolean[] numbers) {
        for (int i = 2; i <= Math.floor(Math.sqrt(MAX_NUMBER)); i++) {
            if (numbers[i]) {
                for (int j = i*i; j <= MAX_NUMBER; j += i) {
                    numbers[j] = false;
                }
            }
        }

        return numbers;
    }

    private static Set<Integer> primes(boolean[] numbers) {
        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i <= MAX_NUMBER; i++) {
            if (numbers[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean isPalindrome(int number) {
        return String.valueOf(number).equals(String.valueOf(reverseNumber(number)));
    }

    private static boolean isReverseAPrime(int number) {
        return primeSet.contains(reverseNumber(number));
    }

    private static int reverseNumber(int number) {
        StringBuilder numberStringBuilder = new StringBuilder(String.valueOf(number));
        return Integer.parseInt(numberStringBuilder.reverse().toString());
    }
}
