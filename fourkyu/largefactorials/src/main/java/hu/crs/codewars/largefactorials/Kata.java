package hu.crs.codewars.largefactorials;

import java.math.BigInteger;

public class Kata {
    public static String Factorial(int n) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial.toString();
    }
}
