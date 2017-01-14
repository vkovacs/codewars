package hu.crs.codewars.recursivereversestring;

public class Kata {
    public String reverse(String str) {
        if (str.length() == 1) {
            return str;
        } else {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }
}
