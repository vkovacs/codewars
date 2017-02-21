package hu.crs.codewars.nextbiggernumberwithsamedigits;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("Duplicates")
public class Kata {

    public static long nextBiggerNumber(long n) {
        String s = String.valueOf(n);
        Map<Character, Integer> nMap = createCharacterMap(s);

        if (allDigitsAreTheSame(nMap)) {
            return -1;
        }

        if (isDecreasingSequence(s)) {
            return -1;
        }

        long maxPossibleNumber = createMaxPossibleNumber(s);
        for (long i = n + 1; i  <= maxPossibleNumber; i++) {
            Map<Character, Integer> iMap = createCharacterMap(String.valueOf(i));
            if (containsAllCharacters(iMap, nMap)) {
                return i;
            }
        }
        return -1;
    }

    private static long createMaxPossibleNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append("9");
        }
        return Long.parseLong(sb.toString());
    }

    private static boolean allDigitsAreTheSame(Map<Character, Integer> nMap) {
        return nMap.keySet().size() == 1;
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

    private static boolean isDecreasingSequence(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) < s.charAt(i)) {
                return false;
            }
        }
        return true;
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
}
