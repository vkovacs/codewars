package hu.crs.codewars.threekyu.findntgdigit;

/**
 * Find nth Digit In a Infinite Addition Result
 * <p>
 * https://www.codewars.com/kata/59f6e1af3640ce12510000ad/train/java
 */
public class Kata {
    public static int findDigit(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        throw  new UnsupportedOperationException();
    }

    public static int nthDigitOfFirstLine(final int n) {
        int currentNumber = 1;
        int currentIndex = 0;

        while (currentIndex <= n) {
            String currentNumberString = String.valueOf(currentNumber);
            if (currentIndex + currentNumberString.length() <= n) {
                currentIndex += currentNumberString.length();
            } else {
                return Character.getNumericValue(currentNumberString.charAt(n - currentIndex));
            }
            currentNumber++;
        }
        throw new IllegalStateException();
    }
}
