package hu.crs.codewars.threekyu.closestpairofpoints;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Closest pair of points in linearithmic time
 *
 * https://www.codewars.com/kata/5376b901424ed4f8c20002b7/train/java
 */
public class Kata {
    public static List<Point> closestPair(List<Point> points) {
        Set<Pair> calculatedPointDistances = new HashSet<>();
        double minDistance = Double.MAX_VALUE;
        Point a = null;
        Point b = null;

        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i == j) {
                    continue;
                }
                Pair pair = new Pair(i, j);
                if (!calculatedPointDistances.contains(pair)) {
                    calculatedPointDistances.add(pair);

                    double distance = distance(points.get(i), points.get(j));

                    if (distance < minDistance) {
                        minDistance = distance;
                        a = points.get(i);
                        b = points.get(j);
                    }
                }
            }
        }

        return Arrays.asList(a, b);
    }

    private static double distance(Point a, Point b) {
        double deltaX = Math.abs(a.x - b.x);
        double deltaY = Math.abs(a.y - b.y);
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    private static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b ||
                    a == pair.b && b == pair.a;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
