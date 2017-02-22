package hu.crs.codewars.escapingthematrix;

public class Kata {
    public static void enter() {
        new EvilThrower<RuntimeException>().sneakyThrow(new Neo());
    }

    public static class EvilThrower<T extends Throwable> {
        void sneakyThrow(Exception exception) throws T {
            throw (T) exception;
        }
    }
}
