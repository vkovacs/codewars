package hu.crs.codewars.sixkyu.findmissingletter;

/**
 * Find the missing letter
 *
 * https://www.codewars.com/kata/5839edaa6754d6fec10000a2/train/java
 */
class Kata {
    static char findMissingLetter(char[] array) {
        int previous = array[0];
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            if (current - previous > 1) {
                return ((char) (current - 1));
            }
            previous = current;
        }
        throw new IllegalArgumentException();
    }
}
