package hu.crs.codewars.sevenkyu.isograms;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Isograms {
    public static boolean  isIsogram(String word) {
        var lettersDistribution = Arrays.stream(word.toLowerCase().split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return lettersDistribution.values().stream()
                .filter(number -> number > 1)
                .findAny()
                .isEmpty();

    }
}
