package hu.crs.codewars.sixkyu.pascalstriangle2;

public class Kata {
    public static int[][] pascal(int depth) {
        int[][] result = new int[depth][];
        result[0] = new int[]{1};

        for (int i = 1; i <= depth - 1; i++) {
            int[] subArray = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if ((j == 0) || (j == i)) {
                    subArray[j] = 1;
                } else {
                    subArray[j] = result[i - 1][j - 1] + result[i - 1][j];
                }
            }
            result[i] = subArray;
        }

        return result;
    }
}
