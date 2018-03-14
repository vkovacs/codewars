package hu.crs.codewars.sixkyu.yourorderplease;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.StringJoiner;
import java.util.TreeMap;

/**
 * Your order, please
 *
 * https://www.codewars.com/kata/55c45be3b2079eccff00010f/train/java
 */
public class Kata {
    public static String order(String words) {
        if ("".equals(words)) {
            return "";
        }

        final SortedMap<Integer, String> wordMap = fillWordMap(words.split(" "));

        StringJoiner stringJoiner = new StringJoiner(" ");
        wordMap.keySet().forEach(k -> stringJoiner.add(wordMap.get(k)));

        return stringJoiner.toString();
    }

    private static SortedMap<Integer, String> fillWordMap(String[] wordArray) {
        SortedMap<Integer, String> wordMap = new TreeMap<>();

        Arrays.stream(wordArray).forEach( word -> {
                    final int number = findNumber(word);
                    wordMap.put(number, word);
                }
        );

        return wordMap;
    }

    private static int findNumber(String word) {
        for (int i = 0; i < word.length(); i++) {
            final char character = word.charAt(i);
            if (Character.isDigit(character)) {
                return Integer.parseInt(String.valueOf(character));
            }
        }
        throw new IllegalArgumentException("No number found.");
    }
}
