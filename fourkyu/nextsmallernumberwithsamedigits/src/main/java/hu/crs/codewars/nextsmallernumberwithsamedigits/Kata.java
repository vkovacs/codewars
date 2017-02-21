package hu.crs.codewars.nextsmallernumberwithsamedigits;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("Duplicates")
public class Kata {
    public static long nextSmaller(long n) {

        String s = String.valueOf(n);
        Map<Character, Integer> nMap = createCharacterMap(s);

        if (allDigitsAreTheSame(nMap)) {
            return -1;
        }

        if (isIncreasingSequence(s)) {
            return -1;
        }

        if (isIncreasingSequenceButSecondIs0(s)) {
            return -1;
        }

        long minPossibleNumber = (long) Math.pow(10, s.length() - 1);
        for (long i = n - 1; i > minPossibleNumber; i--) {
            Map<Character, Integer> iMap = createCharacterMap(String.valueOf(i));
            if (containsAllCharacters(iMap, nMap)) {
                return i;
            }
        }

        return -1;
    }

    private static boolean allDigitsAreTheSame(Map<Character, Integer> nMap) {
        if (nMap.keySet().size() == 1) {
            return true;
        }
        return false;
    }

    private static Map<Character, Integer> createCharacterMap(String s) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            final Set<Character> characters = characterMap.keySet();
            if (characters.contains(character)) {
                Integer value = characterMap.get(character);
                characterMap.put(character, ++value);
            } else {
                characterMap.put(character, 0);
            }
        }
        return characterMap;
    }

    private static boolean containsAllCharacters(Map<Character, Integer> availableCharacterMap, Map<Character, Integer> neededCharacterMap) {
        final Set<Character> neededCharacters = neededCharacterMap.keySet();
        for (Character neededCharacter : neededCharacters) {
            if (availableCharacterMap.get(neededCharacter) == null || availableCharacterMap.get(neededCharacter) < neededCharacterMap.get(neededCharacter)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIncreasingSequence(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIncreasingSequenceButSecondIs0(String s) {
        if (!String.valueOf(s.charAt(1)).equals("0")) {
            return false;
        }

        List<Character> characters = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            characters.add(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        characters.remove(1);

        for (Character character : characters) {
            sb.append(character);
        }

        return isIncreasingSequence(sb.toString());

    }

}


