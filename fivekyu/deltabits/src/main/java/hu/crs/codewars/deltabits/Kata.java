package hu.crs.codewars.deltabits;

public class Kata {

    public static int convertBits(int a, int b) {
        return Integer.bitCount(a ^ b);
    }
}
