package hu.crs.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class KataTest {

    @Test
    public void testNoComment() {
        String input = "apple, orange";
        assertEquals(input, Kata.stripComments(input, new String[]{}));
    }

    @Test
    public void testTrimTrailingWhiteSpaces() {
        assertEquals("apple, orange", Kata.stripComments("apple, orange ", new String[]{}));
    }

    @Test
    public void testKeepLeadingWhiteSpace() {
        assertEquals(" apple, orange", Kata.stripComments(" apple, orange ", new String[]{}));
    }

    @Test
    public void testStripOneKindOfComment() {
        assertEquals("apple, orange", Kata.stripComments("apple, orange #comment", new String[]{"#"}));
    }

    @Test
    public void testStripOneKindOfCommentMultiLineInput() {
        assertEquals("apple, orange\npear", Kata.stripComments("apple, orange #comment0\npear #comment1", new String[]{"#"}));
    }

    @Test
    public void testStripMultipleKindOfComment() {
        assertEquals("apple, orange\npear", Kata.stripComments("apple, orange #comment0\npear !comment1", new String[]{"#", "!"}));
    }

    @Test
    public void testStripJustComment() {
        assertEquals("", Kata.stripComments("###", new String[]{"#"}));
    }

    @Test
    public void codeWarsTest0() throws Exception {
        assertEquals(
                "apples, pears\ngrapes\nbananas",
                Kata.stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"})
        );
    }

    @Test
    public void codeWarsTest1() throws Exception {
        assertEquals(
                "a\nc\nd",
                Kata.stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"})
        );

    }
}
