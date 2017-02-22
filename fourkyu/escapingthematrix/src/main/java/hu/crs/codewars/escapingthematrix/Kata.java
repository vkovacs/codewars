package hu.crs.codewars.escapingthematrix;

public class Kata {
    public static void enter() {
        Kata.sneakyThrow();
    }

    static <T extends Throwable> void sneakyThrow() throws T {
        throw (T) new Neo();
    }
}
