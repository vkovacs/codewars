package hu.crs.codewars.sixkyu.findtheoddint;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Find the odd int
 *
 * https://www.codewars.com/kata/54da5a58ea159efa38000836
 */
public class Kata {
    public static int findIt(int[] a) {
        return Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet().stream()
                .filter(e -> e.getValue().size() % 2 != 0)
                .findFirst()
                .map(Map.Entry::getKey)
                .get();
    }
}
