package hu.crs.codewars.threekyu.findntgdigit;

/**
 * Find nth Digit In a Infinite Addition Result
 * <p>
 * https://www.codewars.com/kata/59f6e1af3640ce12510000ad/train/java
 */
public class Kata {
    private static String firstLine;
    private static String secondLine;

    private static void generateLines(int minPosition) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int number1 = 1;
        int number2 = number1 * number1;

        while (sb1.length() <= minPosition + 1 || sb2.length() <= minPosition + 1) {
            sb1.append(number1);
            sb2.append(number2);
            number1++;
            number2 = number1 * number1;
        }

        int i = minPosition;
        while (Character.getNumericValue(sb1.charAt(i + 1)) + Character.getNumericValue(sb2.charAt(i + 1)) > 8) {
            sb1.append(number1);
            sb2.append(number2);
            number1++;
            number2 = number1 * number1;
            i++;
        }
        firstLine = sb1.toString();
        secondLine = sb2.toString();
    }


    public static int findDigit(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        generateLines(n);

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

    private static int nthDigitOfSecondLine(int i) {
        return Character.getNumericValue(secondLine.charAt(i));
    }

    private static int nthDigitOfFirstLine(int i) {
        return Character.getNumericValue(firstLine.charAt(i));
    }
}
