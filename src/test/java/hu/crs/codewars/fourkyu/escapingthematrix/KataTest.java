package hu.crs.codewars.fourkyu.escapingthematrix;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KataTest {

    @Test
    public void test() {
        Assertions.assertThrows(Neo.class, Kata::enter);
    }
}
