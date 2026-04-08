package hu.crs.codewars.sevenkyu.isograms;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;

public class IsogramsTest {
    Isograms underTest = new Isograms();

    @CsvSource({
            "Dermatoglyphics, true",
            "aba, false",
            "moOse, false"
    })
    @ParameterizedTest
    void testIsograms(String word, boolean expected) {
        MatcherAssert.assertThat(underTest.isIsogram(word), is(expected));
    }
}
