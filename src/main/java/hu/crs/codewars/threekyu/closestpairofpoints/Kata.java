package hu.crs.codewars.threekyu.closestpairofpoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.Math.min;

/**
 * Closest pair of points in linearithmic time
 * <p>
 * https://www.codewars.com/kata/5376b901424ed4f8c20002b7/train/java
 */
public class Kata {
    public static List<Point> closestPair(List<Point> points) {

        if (points.size() < 4) {
            return closestPairsBruteForce(points);
        }

        points.sort(Comparator.comparingDouble(a -> a.x));

        int separatorIndex = (int) Math.ceil(points.size() / 2) - 1;

        List<Point> pointsL = points.subList(0, separatorIndex + 1);
        List<Point> pointsR = points.subList(separatorIndex + 1, points.size());

        List<Point> closestPairsL = closestPair(pointsL);
        List<Point> closestPairsR = closestPair(pointsR);

        List<Point> closestPairsLRBorder = findClosestPairsLRBorder(points, min(distance(closestPairsL), distance(closestPairsR)));

        double distanceL = distance(closestPairsL);
        double distanceR = distance(closestPairsR);
        double distanceLR = distance(closestPairsLRBorder);
        if (distanceL <= distanceR && distanceL <= distanceLR) return closestPairsL;
        if (distanceR <= distanceL && distanceR <= distanceLR) return closestPairsR;
        return closestPairsLRBorder;

    }

    private static List<Point> findClosestPairsLRBorder(List<Point> points, double minClosestPairsLRDistance) {
        points.sort(Comparator.comparingDouble(a -> a.x));

        int separatorIndex = (int) Math.ceil(points.size() / 2) - 1;
        int actualIndex = separatorIndex;
        final Point referencePoint = points.get(separatorIndex);

        List<Point> pointInStripe = new ArrayList<>();
        while (actualIndex > 0 && Math.abs(points.get(actualIndex).x - referencePoint.x) < minClosestPairsLRDistance) {
            pointInStripe.add(points.get(actualIndex));
            actualIndex--;
        }

        actualIndex = separatorIndex + 1;
        while (actualIndex < points.size() && Math.abs(points.get(actualIndex).x - referencePoint.x) < minClosestPairsLRDistance) {
            pointInStripe.add(points.get(actualIndex));
            actualIndex++;
        }

        if (pointInStripe.size() > 1) {
            List<Point> closesPairsInStripe = closestPairsBruteForce(pointInStripe);
            if (distance(closesPairsInStripe) < minClosestPairsLRDistance) {
                return closesPairsInStripe;
            }
        }

        return new ArrayList<>();
    }

    private static List<Point> closestPairsBruteForce(List<Point> points) {
        double minDistance = Double.MAX_VALUE;
        Point a = null;
        Point b = null;

        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i == j) continue;

                double distance = distance(points.get(i), points.get(j));
                if (distance < minDistance) {
                    minDistance = distance;
                    a = points.get(i);
                    b = points.get(j);
                }
            }
        }

        return Arrays.asList(a, b);
    }

    private static double distance(List<Point> points) {
        if (points.size() != 2) {
            return Double.MAX_VALUE;
        }
        return distance(points.get(0), points.get(1));
    }

    private static double distance(Point a, Point b) {
        double deltaX = Math.abs(a.x - b.x);
        double deltaY = Math.abs(a.y - b.y);
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

}
