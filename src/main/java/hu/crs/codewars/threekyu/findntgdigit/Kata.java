package hu.crs.codewars.threekyu.findntgdigit;

import static java.lang.Character.getNumericValue;

/**
 * Find nth Digit In a Infinite Addition Result
 * <p>
 * https://www.codewars.com/kata/59f6e1af3640ce12510000ad/train/java
 */
public class Kata {
    private static final int MAX_LENGTH = (int) Math.pow(2, 31) - 1;


    public static int findDigit(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        String firstLine = generateFirstLine(MAX_LENGTH);
        String secondLine = generateSecondLine(firstLine, MAX_LENGTH);
        String sum = sum(firstLine, secondLine);

        return Character.getNumericValue(sum.charAt(n));
    }

    public static String generateFirstLine(int maxLength) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        do {
            sb.append(i + 1);
            i++;
        } while (sb.length() <= maxLength);

        return sb.substring(0, maxLength + 1);
    }

    public static String generateSecondLine(String firstLine, int maxLength) {
        StringBuilder secondLine = new StringBuilder();
        int i = 0;
        do {
            int currentNumber = getNumericValue(firstLine.charAt(i));
            secondLine.append(currentNumber * currentNumber);
            i++;
        } while (secondLine.length() <= maxLength);
        return secondLine.substring(0, maxLength + 1);
    }

    public static String sum(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            throw new IllegalArgumentException();
        }

        StringBuilder sum = new StringBuilder();

        int i = a.length() - 1;
        int carry = 0;
        do {
            int total = getNumericValue(a.charAt(i)) + getNumericValue(b.charAt(i)) + carry;
            int sumOnIndexResult = total % 10;
            carry = total / 10;
            sum.insert(0, sumOnIndexResult);
            i--;
        } while (i >= 0);
        if (carry > 0) {
            sum.insert(0, carry);
        }
        return sum.toString();
    }
}
