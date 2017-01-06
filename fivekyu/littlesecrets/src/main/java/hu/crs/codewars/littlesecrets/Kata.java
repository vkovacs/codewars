package hu.crs.codewars.littlesecrets;

import java.lang.reflect.Field;

public class Kata {

    public static void main(String[] args) {
        try {
            final Field mySecret = LittleClass.class.getDeclaredField("secret");
            mySecret.setAccessible(true);

            String secret = (String) mySecret.get(null);
            System.out.println(secret);
            System.out.println(LittleClass.isMySecret(secret));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
