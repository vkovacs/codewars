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
        List<ChromosomeProbability> sortedChromosomeProbabilities = chromosomeProbabilities(population, fitnesses);

        String chromosome0 = selectChromosome(sortedChromosomeProbabilities);
        String chromosome1 = selectChromosome(sortedChromosomeProbabilities);

        return new String[]{chromosome0, chromosome1};
    }

    private String selectChromosome(List<ChromosomeProbability> sortedChromosomeProbabilities) {
        double randomDouble = ThreadLocalRandom.current().nextDouble();

        String selectedChromosome = sortedChromosomeProbabilities.get(0).chromosome;
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

    private List<ChromosomeProbability> chromosomeProbabilities(List<String> population, List<Double> fitnesses) {
        final Double sumOfFitnesses = fitnesses.stream().mapToDouble(Double::doubleValue).sum();

        List<ChromosomeProbability> chromosomeProbabilities = new ArrayList<>();
        for (int i = 0; i < population.size(); i++) {
            Double probability = fitnesses.get(i) / sumOfFitnesses;
            chromosomeProbabilities.add(new ChromosomeProbability(population.get(i), probability));
        }

        Collections.sort(chromosomeProbabilities);
        return chromosomeProbabilities;
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
}