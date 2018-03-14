package hu.crs.codewars.sixkyu.worda10n;

/**
 * Word a10n (abbreviation)
 *
 * https://www.codewars.com/kata/word-a10n-abbreviation/train/java
 */
public class Kata {
    public static String abbreviate(String string) {
        StringBuilder tmp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i))) {
                tmp.append(string.charAt(i));
            } else {
                result.append(doAbbreviate(tmp.toString()));
                tmp = new StringBuilder();
                result.append(string.charAt(i));
            }
        }
        result.append(doAbbreviate(tmp.toString()));

        return result.toString();
    }

    private static String doAbbreviate(String s) {
        if (s.length() < 4) {
            return s;
        } else {
            return (s.charAt(0)) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
        }
    }
}
