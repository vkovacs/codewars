package hu.crs.codewars.findmissingletter;

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
        throw new RuntimeException("Invalid input");
    }
}
