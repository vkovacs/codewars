package hu.crs.codewars.threekyu.closestpairofpoints;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KataTest {

    @Test
    public void test01_Example() {

        List<Point> points = Arrays.asList(
                new Point(2, 2), //A
                new Point(2, 8), //B
                new Point(5, 5), //C
                new Point(6, 3), //D
                new Point(6, 7), //E
                new Point(7, 4), //F
                new Point(7, 9)  //G
        );

        List<Point> result = Kata.closestPair(points);
        List<Point> expected = Arrays.asList(new Point(6, 3), new Point(7, 4));
        verify(expected, result);
    }

    @Test
    public void test02_TwoPoints() {

        List<Point> points = Arrays.asList(
                new Point(2, 2),
                new Point(6, 3)
        );

        List<Point> result = Kata.closestPair(points);
        List<Point> expected = Arrays.asList(new Point(6, 3), new Point(2, 2));
        verify(expected, result);
    }

    @Test
    public void test03_DuplicatedPoint() {

        List<Point> points = Arrays.asList(
                new Point(2, 2), //A
                new Point(2, 8), //B
                new Point(5, 5), //C
                new Point(5, 5), //C
                new Point(6, 3), //D
                new Point(6, 7), //E
                new Point(7, 4), //F
                new Point(7, 9)  //G
        );

        List<Point> result = Kata.closestPair(points);
        List<Point> expected = Arrays.asList(new Point(5, 5), new Point(5, 5));
        verify(expected, result);
    }

    @Test
    public void test07_DuplicatedPoint() {
        List<Point> points = Arrays.asList(
                new Point(-0.393321, 1.098307),
                new Point(-0.563322, 0.650391),
                new Point(-0.454702, 0.976535),
                new Point(-0.137419, 0.986869),
                new Point(-0.634385, 0.747714),
                new Point(-0.239608, 1.173094),
                new Point(-0.505300, 0.243190),
                new Point(-0.022767, 0.654085),
                new Point(-0.051426, 0.202316),
                new Point(-0.264477, 0.444384),
                new Point(-0.873145, 0.223207),
                new Point(0.055569, 0.494773),
                new Point(-0.768407, 0.023215),
                new Point(-0.429105, 0.039191),
                new Point(-0.718738, 0.240633),
                new Point(-0.431552, 0.631825),
                new Point(-0.168879, 1.081264),
                new Point(-0.278783, 1.033276),
                new Point(-0.264888, 0.216569),
                new Point(-0.645911, 0.521396),
                new Point(-0.871943, 0.543433),
                new Point(-0.323190, 0.303888),
                new Point(0.035392, 0.340747),
                new Point(-0.587262, 0.432479),
                new Point(-0.587015, 0.101311),
                new Point(0.036109, 0.258248),
                new Point(-0.377928, 0.980550),
                new Point(-0.243728, 0.721593),
                new Point(-0.463151, 0.123267),
                new Point(-0.495785, 1.024229),
                new Point(-0.220144, 0.109609),
                new Point(-0.722191, 0.495351),
                new Point(-0.556795, 0.575117),
                new Point(-0.102154, 0.429532),
                new Point(-0.039173, 0.438291),
                new Point(-0.716502, -0.101813),
                new Point(-0.972219, 0.504099),
                new Point(0.138436, 0.378261),
                new Point(0.127821, 0.311690),
                new Point(-0.714436, 0.701625),
                new Point(-0.681621, 0.636769),
                new Point(-0.072505, 0.865280),
                new Point(-0.178099, 0.239919),
                new Point(-0.633183, 1.010336),
                new Point(-0.242356, 0.953903),
                new Point(-0.788482, 0.830971),
                new Point(-0.795783, 0.096222),
                new Point(-0.201262, 0.584141),
                new Point(-0.350517, 0.669629),
                new Point(-0.492562, 0.484749),
                new Point(-0.864992, 0.335107),
                new Point(-0.375000, 0.754042),
                new Point(-0.914019, 0.409163),
                new Point(-0.722220, 0.948141),
                new Point(-0.354539, 0.102611),
                new Point(-0.224223, 0.377781),
                new Point(-0.587201, 0.197974),
                new Point(-0.540949, 0.315321),
                new Point(-0.413397, 0.845324),
                new Point(-0.494143, 0.796491),
                new Point(-0.122476, 0.641193),
                new Point(-0.279602, 0.560880),
                new Point(-0.304390, 1.133492),
                new Point(-0.391123, 0.744852),
                new Point(-0.675438, 0.407436),
                new Point(-0.988239, 0.830853),
                new Point(-0.799978, 0.938222),
                new Point(-1.033070, 0.609214),
                new Point(-0.903167, 0.631319),
                new Point(-1.041172, 0.682586),
                new Point(-0.047266, 0.560388),
                new Point(0.014755, 0.569884),
                new Point(-0.626977, 0.294653),
                new Point(-0.799093, 0.693707),
                new Point(-0.842885, 0.812575),
                new Point(-0.933328, 0.745248),
                new Point(-0.595272, -0.051161),
                new Point(-0.913977, 0.872483),
                new Point(-0.394549, 0.286571),
                new Point(-0.527634, 0.027228),
                new Point(-0.369775, 0.408164),
                new Point(-0.756134, 0.589796),
                new Point(-0.479768, 0.698617),
                new Point(-0.120124, 0.739769),
                new Point(-0.328653, 0.873983),
                new Point(-0.022402, 0.779676),
                new Point(-0.385962, 0.510002),
                new Point(-0.466865, 0.389416),
                new Point(-0.198270, 0.806181),
                new Point(-0.655841, 0.887247),
                new Point(-0.850001, 0.438743),
                new Point(-0.314423, 0.804971),
                new Point(-1.095077, 0.808296),
                new Point(-0.390450, 0.177462),
                new Point(-0.113388, 0.185599),
                new Point(-0.789928, 0.357409),
                new Point(-0.183917, 0.511614),
                new Point(-0.587262, 0.432479),
                new Point(-0.716054, 0.138362),
                new Point(-0.084734, 0.316660),
                new Point(-0.679320, 0.045773),
                new Point(-0.596448, 0.917609)

        );

        List<Point> result = Kata.closestPair(points);
        List<Point> expected = Arrays.asList(new Point(-0.587262, 0.432479), new Point(-0.587262, 0.432479));
        verify(expected, result);
    }

    @Test
    public void hasCloserPointPairInDeltaRectangleSameX() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(12, 10), new Point(5, 10), new Point(20, 10));
        List<Point> result = Kata.closestPair(points);
        List<Point> expected = Arrays.asList(new Point(10, 10), new Point(12, 10));
        verify(expected, result);
    }

    @Test
    public void small() {
        List<Point> points = Arrays.asList(
                new Point(-0.006447, 0.010374),
                new Point(0.011665, 0.025536),
                new Point(-0.001568, 0.035476),
                new Point(-0.021247, 0.033317),
                new Point(0.003751, 0.017648),
                new Point(-0.016181, 0.015927),
                new Point(0.008292, 0.031737),
                new Point(-0.007024, 0.019015),
                new Point(-0.026606, 0.008104),
                new Point(-0.011769, 0.029984),
                new Point(-0.009395, 0.006417),
                new Point(-0.003285, 0.004774),
                new Point(0.000374, 0.010087),
                new Point(-0.011781, 0.023689),
                new Point(0.015278, 0.029784),
                new Point(-0.019336, 0.026063),
                new Point(-0.009407, 0.039589),
                new Point(-0.003033, 0.028444),
                new Point(0.004719, 0.000189),
                new Point(-0.017034, 0.005233),
                new Point(0.008119, 0.010231),
                new Point(-0.023718, 0.018747),
                new Point(-0.016806, 0.040249),
                new Point(-0.019740, 0.033049),
                new Point(0.003579, 0.027360),
                new Point(0.009840, 0.014372)
        );

        List<Point> result = Kata.closestPair(points);
        List<Point> expected = Arrays.asList(new Point(-0.021247, 0.033317), new Point(-0.019740, 0.033049));
        verify(expected, result);
    }

    private void verify(List<Point> expected, List<Point> actual) {
        Comparator<Point> comparer = Comparator.comparingDouble(p -> p.x);

        Assert.assertNotNull("Returned array cannot be null.", actual);
        Assert.assertEquals("Expected exactly two points.", 2, actual.size());
        Assert.assertFalse("Returned points must not be null.", actual.get(0) == null || actual.get(1) == null);

        expected.sort(comparer);
        actual.sort(comparer);
        boolean eq = expected.get(0).x == actual.get(0).x && expected.get(0).y == actual.get(0).y
                && expected.get(1).x == actual.get(1).x && expected.get(1).y == actual.get(1).y;
        Assert.assertTrue(String.format("Expected: %s, Actual: %s", expected.toString(), actual.toString()), eq);
    }
}
