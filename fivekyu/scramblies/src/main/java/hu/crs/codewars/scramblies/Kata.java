package hu.crs.codewars.scramblies;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Kata {
    public static boolean scramble(String str1, String str2) {
        final Map<Character, Integer> str1CharacterMap = createCharacterMap(str1);
        final Map<Character, Integer> str2CharacterMap = createCharacterMap(str2);

        return containsAllCharacters(str1CharacterMap, str2CharacterMap);
    }

    private static Map<Character, Integer> createCharacterMap(String s) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            final Set<Character> characters = characterMap.keySet();
            if (!characters.contains(character)) {
                characterMap.put(character, 0);
            } else {
                Integer value = characterMap.get(character);
                characterMap.put(character, ++value);
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

}
