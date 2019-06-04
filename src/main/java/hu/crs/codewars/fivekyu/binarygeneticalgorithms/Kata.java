package hu.crs.codewars.fivekyu.binarygeneticalgorithms;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Kata {

    String generate(int length) {
        return Stream.generate(() -> Integer.toString(ThreadLocalRandom.current().nextInt(2)))
                .limit(length)
                .collect(Collectors.joining());
    }

    String[] select(List<String> population, List<Double> fitnesses) {
        throw new UnsupportedOperationException();
    }

    String mutate(String chromosome, double p) {
        throw new UnsupportedOperationException();
    }

    String[] crossover(String chromosome1, String chromosome2) {
        throw new UnsupportedOperationException();
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m) {
        throw new UnsupportedOperationException();
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m, int iterations) {
        throw new UnsupportedOperationException();
    }
}