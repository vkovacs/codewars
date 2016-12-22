package hu.crs.codewars.autocorrect;

class Kata {

    private static final String AUTO_CORRECTED_STRING = "your sister";

    static String autocorrect(String input) {
        String[] words = input.split("[ ,!?'=]+");
        String[] delimiters = input.split("[a-zA-Z<0-3]+");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(autocorrectWord(words[i]));
            if (i < delimiters.length - 1) {
                result.append(delimiters[i + 1]);
            }
        }

        return result.toString();
    }

    private static String autocorrectWord(String word) {
        String result = word.replaceAll("^[uU]$", AUTO_CORRECTED_STRING);
        result = result.replaceAll("^[yY][oO][uU]+$", AUTO_CORRECTED_STRING);
        return result;
    }
}
