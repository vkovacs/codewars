package hu.crs.codewars.threekyu.closestpairofpoints;

import java.util.Arrays;
import java.util.List;

/**
 * Closest pair of points in linearithmic time
 *
 * https://www.codewars.com/kata/5376b901424ed4f8c20002b7/train/java
 */
public class Kata {
    public static List<Point> closestPair(List<Point> points) {
        double minDistance = Double.MAX_VALUE;
        Point a = null;
        Point b = null;

        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i == j) {
                    continue;
                }
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

    private static double distance(Point a, Point b) {
        double deltaX = Math.abs(a.x - b.x);
        double deltaY = Math.abs(a.y - b.y);
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

}
