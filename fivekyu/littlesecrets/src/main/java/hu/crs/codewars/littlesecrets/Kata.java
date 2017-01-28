package hu.crs.codewars.littlesecrets;

import java.lang.reflect.Field;

public class Kata {

    public static String guess(String fieldName) throws NoSuchFieldException, IllegalAccessException {
            final Field mySecret = LittleClass.class.getDeclaredField(fieldName);
            mySecret.setAccessible(true);

            return (String) mySecret.get(null);

    }
}
