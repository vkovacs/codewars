package hu.crs.codewars.fivekyu.binarygeneticalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Binary Genetic Algorithms
 * <p>
 * https://www.codewars.com/kata/binary-genetic-algorithms
 */
public class Kata {

    String generate(int length) {
        return Stream.generate(() -> Integer.toString(ThreadLocalRandom.current().nextInt(2)))
                .limit(length)
                .collect(Collectors.joining());
    }

    String[] select(List<String> population, List<Double> fitnesses) {
        List<ChromosomeProbability> sortedChromosomeProbabilities = orderedChromosomeProbabilities(population, fitnesses);

        String chromosome0 = selectChromosome(sortedChromosomeProbabilities);
        String chromosome1 = selectChromosome(sortedChromosomeProbabilities);

        return new String[]{chromosome0, chromosome1};
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
        if (chromosome1.length() != chromosome2.length())
            throw new IllegalArgumentException("Chromosomes must have the same size!");
        int splitPosition = ThreadLocalRandom.current().nextInt(chromosome1.length() - 1);

        return crossoverSplit(chromosome1, chromosome2, splitPosition);
    }

    String[] crossoverSplit(String chromosome1, String chromosome2, int splitPosition) {
        String crossoverChromosome1 = chromosome1.substring(0, splitPosition) + chromosome2.substring(splitPosition);
        String crossoverChromosome2 = chromosome2.substring(0, splitPosition) + chromosome1.substring(splitPosition);

        return new String[]{crossoverChromosome1, crossoverChromosome2};
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m) {
        throw new UnsupportedOperationException();
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m, int iterations) {
        throw new UnsupportedOperationException();
    }

    private static class ChromosomeProbability implements Comparable<ChromosomeProbability> {
        private final String chromosome;
        private final Double probability;

        ChromosomeProbability(String chromosome, Double probability) {
            this.chromosome = chromosome;
            this.probability = probability;
        }

        @Override
        public int compareTo(ChromosomeProbability o) {
            if (probability < o.probability) {
                return -1;
            } else if (probability > o.probability) {
                return 1;
            }
            return 0;
        }
    }

    private String selectChromosome(List<ChromosomeProbability> sortedChromosomeProbabilities) {
        if (sortedChromosomeProbabilities.isEmpty()) {
            throw new IllegalArgumentException("Chromosomes not present!");
        }

        String selectedChromosome = sortedChromosomeProbabilities.get(0).chromosome;
        double randomDouble = ThreadLocalRandom.current().nextDouble();

        Double previousProbability = 0d;
        for (int i = 1; i < sortedChromosomeProbabilities.size(); i++) {
            ChromosomeProbability chromosomeProbability = sortedChromosomeProbabilities.get(i);

            if (previousProbability + chromosomeProbability.probability < randomDouble) {
                previousProbability = previousProbability + chromosomeProbability.probability;
                selectedChromosome = chromosomeProbability.chromosome;
            } else {
                return selectedChromosome;
            }
        }
        return selectedChromosome;
    }

    private List<ChromosomeProbability> orderedChromosomeProbabilities(List<String> population, List<Double> fitnesses) {
        final Double sumOfFitnesses = fitnesses.stream().mapToDouble(Double::doubleValue).sum();

        List<ChromosomeProbability> chromosomeProbabilities = new ArrayList<>();
        for (int i = 0; i < population.size(); i++) {
            Double probability = fitnesses.get(i) / sumOfFitnesses;
            chromosomeProbabilities.add(new ChromosomeProbability(population.get(i), probability));
        }

        Collections.sort(chromosomeProbabilities);
        return chromosomeProbabilities;
    }
}