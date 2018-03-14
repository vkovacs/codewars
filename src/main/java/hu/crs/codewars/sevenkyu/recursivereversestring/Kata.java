package hu.crs.codewars.sevenkyu.recursivereversestring;

/**
 * Recursive reverse string
 *
 * https://www.codewars.com/kata/536a9f94021a76ef0f00052f
 */

public class Kata {
    public String reverse(String str) {
        if (str.length() == 1) {
            return str;
        } else {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }
}
