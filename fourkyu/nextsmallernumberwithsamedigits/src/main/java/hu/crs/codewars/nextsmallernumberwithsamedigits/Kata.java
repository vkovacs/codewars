package hu.crs.codewars.nextsmallernumberwithsamedigits;

public class Kata {
    public static long nextSmaller(long n) {

        final String nString = String.valueOf(n);
        final String newString = changeDigits(String.valueOf(n), true);
        if (nString.equals(newString)) {
            return -1;
        }

        return Long.parseLong(newString);
    }

    private static String changeDigits(String nString, boolean firstRun) {
        if (nString.length() == 1) {
            return nString;
        }

        int i = nString.length() - 1;

        int previousDigitPos = i;
        i--;
        while (i >= 0) {
            int currentDigitPos = i;
            if (nString.charAt(currentDigitPos) > nString.charAt(previousDigitPos) || (!firstRun && nString.charAt(currentDigitPos) == '0')) {
                char[] nChars = nString.toCharArray();
                final char largerDigit = nChars[currentDigitPos];
                nChars[currentDigitPos] = nChars[previousDigitPos];
                nChars[previousDigitPos] = largerDigit;

                final String newString = String.valueOf(nChars);
                return newString.charAt(0) + changeDigits(newString.substring(1, newString.length()), false);
            }
            i--;
        }
        return nString;
    }
}


