package hu.crs.codewars.sixkyu.autocorrect;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void testApply() {
        String[] inputs = new String[] {
                "u",
                "you",
                "Youuuuu",
                "youtube",
                "I miss you!",
                "bayou",
                "u want to go to the movies?",
                "You u youville utube you youyouyou uuu raiyou united youuuu u you",
                "You = best kisser",
                "i <3 u"
        };

        String[] outputs = new String[] {
                "your sister",
                "your sister",
                "your sister",
                "youtube",
                "I miss your sister!",
                "bayou",
                "your sister want to go to the movies?",
                "your sister your sister youville utube your sister youyouyou uuu raiyou united your sister your sister your sister",
                "your sister = best kisser",
                "i <3 your sister"
        };

        for (int i = 0; i < inputs.length; i++) {
            assertEquals(String.format("Wrong result for \"%s\":", inputs[i]), outputs[i], Kata.autocorrect(inputs[i]));
        }
    }
}
