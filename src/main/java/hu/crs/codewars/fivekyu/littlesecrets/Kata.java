package hu.crs.codewars.fivekyu.littlesecrets;

import java.lang.reflect.Field;

/**
 * Everyone has his little secrets
 *
 * https://www.codewars.com/kata/everyone-has-his-little-secrets/train/java
 */
public class Kata {

    public static String guess(String fieldName) throws NoSuchFieldException, IllegalAccessException {
            final Field mySecret = LittleClass.class.getDeclaredField(fieldName);
            mySecret.setAccessible(true);

            return (String) mySecret.get(null);

    }
}
