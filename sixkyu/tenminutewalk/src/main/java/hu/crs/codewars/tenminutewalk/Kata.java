package hu.crs.codewars.tenminutewalk;

import java.util.HashMap;
import java.util.Map;

public class Kata {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10) {
            return false;
        }
        Map<Character, Integer> directionMap = new HashMap<>();
        for (char aWalk : walk) {
            Integer directionCount = directionMap.get(aWalk);
            directionMap.put(aWalk, directionCount != null ? directionCount + 1 : 0);
        }

        return (directionMap.get('n') == null || directionMap.get('n').equals(directionMap.get('s'))) && (directionMap.get('e') == null || directionMap.get('e').equals(directionMap.get('w')));
    }
}
