package hu.crs.codewars.sevenkyu.functionaladdition;

import java.util.function.Function;

/**
 * Functional addition
 * <p>
 * https://www.codewars.com/kata/functional-addition/train/java
 */
public class FunctionalAddition {
    public static Function<Integer, Integer> add(Integer n) {
        return i -> i + n;
    }
}
