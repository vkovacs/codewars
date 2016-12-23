package hu.crs.codewars.autocorrect;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
        return Stream.of(word)
                .map(s -> s.replaceAll("^[uU]$", AUTO_CORRECTED_STRING))
                .map(s -> s.replaceAll("^[yY][oO][uU]+$", AUTO_CORRECTED_STRING))
                .collect(Collectors.joining());
    }
}
