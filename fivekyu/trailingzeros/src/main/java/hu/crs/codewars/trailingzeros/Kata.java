package hu.crs.codewars.trailingzeros;

public class Kata {
    public static int zeros(int n) {
        int i = 1;
        int sum = 0;

        while (Math.pow(5, i) <= n) {
            sum += Math.floor(n / Math.pow(5, i));
            i++;
        }

        return sum;
    }
}
