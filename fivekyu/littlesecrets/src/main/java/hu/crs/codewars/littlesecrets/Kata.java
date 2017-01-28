package hu.crs.codewars.littlesecrets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class Kata {

    private static final Logger logger = LoggerFactory.getLogger(Kata.class);

    public static void main(String[] args) {
        try {
            final Field mySecret = LittleClass.class.getDeclaredField("secret");
            mySecret.setAccessible(true);

            String secret = (String) mySecret.get(null);
            logger.info("Secret: {}", secret);
            logger.info("Is my secret found? {}", LittleClass.isMySecret(secret));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
