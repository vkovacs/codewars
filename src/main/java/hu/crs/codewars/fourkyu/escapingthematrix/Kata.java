package hu.crs.codewars.fourkyu.escapingthematrix;

/**
 * Escaping The Matrix
 *
 * https://www.codewars.com/kata/escaping-the-matrix/train/java
 */
public class Kata {
    public static void enter() {
        Kata.sneakyThrow();
    }

    static <T extends Throwable> void sneakyThrow() throws T {
        throw (T) new Neo();
    }
}
