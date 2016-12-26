package hu.crs.codewars.powersumdig;

public class Kata {
    public static long powerSumDigTerm(int n) {
        int currentNCount = 0;
        int i = 10;
        while (currentNCount <= n) {
            int sumOfNumbersI = getSumOfNumbers(i);
            if (ifPower(i, sumOfNumbersI)) {
                currentNCount++;
                if (currentNCount == n) {
                    return i;
                }
            }
            i++;
        }
        throw new RuntimeException();
    }

    private static int getSumOfNumbers(int number) {
        int sum = 0;
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length(); i++) {
            sum += Integer.parseInt(String.valueOf(numberString.charAt(i)));
        }
        return sum;
    }

    private static boolean ifPower(int number, int base) {
        if (base == 1) {
            return number == base;
        }
        int i = 0;
        while (Math.pow(base, i) < number) {
            i++;
        }

        return Math.pow(base, i) == number;
    }
}
