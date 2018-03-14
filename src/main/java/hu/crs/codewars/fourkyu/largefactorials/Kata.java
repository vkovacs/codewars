package hu.crs.codewars.fourkyu.largefactorials;

import java.math.BigInteger;

/**
 * Large Factorials
 *
 * https://www.codewars.com/kata/557f6437bf8dcdd135000010
 */
public class Kata {
    public static String Factorial(int n) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial.toString();
    }
}
