package hu.crs.codewars.fivekyu.littlesecrets;

public class LittleClass {

    private static String secret = "netVeryWellProtected";

    public static boolean isMySecret(String guess) {
        return secret.equals(guess);
    }
}
