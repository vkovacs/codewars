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
        int currentPrecision = n;

        while (nthDigitOfFirstLine(currentPrecision + 1) + nthDigitOfSecondLine(currentPrecision + 1) > 8) {
            currentPrecision++;
        }

        int carry = 0;
        StringBuilder sum = new StringBuilder();
        while (currentPrecision >= 0) {
            int total = nthDigitOfFirstLine(currentPrecision) + nthDigitOfSecondLine(currentPrecision) + carry;
            int sumOnIndexResult = total % 10;
            carry = total / 10;
            sum.insert(0, sumOnIndexResult);
            currentPrecision--;
        }
        if (carry > 0) {
            sum.insert(0, carry);
        }

        return Character.getNumericValue(sum.charAt(n));
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

    public static int nthDigitOfSecondLine(final int n) {
        int currentNumberOfSecondLine = 1;
        int currentIndexInSecondLine = 0;

        int i = 1;
        while (currentIndexInSecondLine <= n) {
            String currentNumberString = String.valueOf(currentNumberOfSecondLine);
            if (currentIndexInSecondLine + currentNumberString.length() <= n) {
                currentIndexInSecondLine += currentNumberString.length();
            } else {
                return Character.getNumericValue(currentNumberString.charAt(n - currentIndexInSecondLine));
            }

            i++;
            currentNumberOfSecondLine = i * i;
        }
        throw new IllegalStateException();
    }
}
