package hu.crs.codewars.fivekyu.rockingrobin;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class KataTest {
    @Test
    public void testRoundRobinIteration() throws Exception {
        Collection<Integer> one = Collections.singleton(1);
        Collection<Integer> two = Arrays.asList(2, 3);
        Collection<Integer> three = Arrays.asList(4, 5, 6);
        Kata robin = new Kata(Arrays.asList(one.iterator(), two.iterator(), three.iterator()));

        List<Integer> progression = new ArrayList<>(Arrays.asList(1, 2, 4, 3, 5, 6));

        while (robin.hasNext()) {
            Integer i = robin.next();

            if (i != null && i.equals(progression.get(0))) {
                progression.remove(0);
            } else {
                fail("incorrect progression over the elements!");
            }
        }

        assertEquals("should have iterated over all elements:", 0, progression.size());

    }
}