package hu.crs.codewars.fivekyu.binarygeneticalgorithms;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Binary Genetic Algorithms
 *
 * https://www.codewars.com/kata/binary-genetic-algorithms
 */
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
        return chromosome.chars()
                .mapToObj(gene -> gene == '1' ? Boolean.TRUE : Boolean.FALSE)
                .map(gene -> {
                    double random = ThreadLocalRandom.current().nextDouble();
                    if (random < p) {
                        return !gene;
                    } else {
                        return gene;
                    }
                })
                .map(bool -> bool ? 1 : 0)
                .map(String::valueOf)
                .collect(Collectors.joining());
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