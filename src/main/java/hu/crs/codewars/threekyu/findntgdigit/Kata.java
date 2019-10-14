package hu.crs.codewars.threekyu.findntgdigit;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Character.getNumericValue;

/**
 * Find nth Digit In a Infinite Addition Result
 * <p>
 * https://www.codewars.com/kata/59f6e1af3640ce12510000ad/train/java
 */
public class Kata {
    private static StringBuilder firstLine;
    private static StringBuilder secondLine;

    private static void generateLines(int minPosition) {
        firstLine = new StringBuilder();
        secondLine = new StringBuilder();

        int number1 = 1;
        int number2 = number1 * number1;

        while (firstLine.length() <= minPosition + 1 || secondLine.length() <= minPosition + 1) {
            firstLine.append(number1);
            secondLine.append(number2);
            number1++;
            number2 = number1 * number1;
        }

        int i = minPosition;
        while (getNumericValue(firstLine.charAt(i + 1)) + getNumericValue(secondLine.charAt(i + 1)) > 8) {
            firstLine.append(number1);
            secondLine.append(number2);
            number1++;
            number2 = number1 * number1;
            i++;
        }
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
        LinkedList<Integer> sumStack = new LinkedList<>();
        while (currentPrecision >= 0) {
            int total = nthDigitOfFirstLine(currentPrecision) + nthDigitOfSecondLine(currentPrecision) + carry;
            int sumOnIndexResult = total % 10;
            carry = total / 10;
            sumStack.addFirst(sumOnIndexResult);
            currentPrecision--;
        }
        if (carry > 0) {
            sumStack.addFirst(carry);
        }

        return sumStack.get(n);
    }

    private static int nthDigitOfFirstLine(int i) {
        return getNumericValue(firstLine.charAt(i));
    }

    private static int nthDigitOfSecondLine(int i) {
        return getNumericValue(secondLine.charAt(i));
    }
}
