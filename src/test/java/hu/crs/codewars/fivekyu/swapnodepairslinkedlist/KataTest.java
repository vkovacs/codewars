package hu.crs.codewars.fivekyu.swapnodepairslinkedlist;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

public class KataTest {
    @Test
    public void basicTests() {
        executeTest(null, Kata.swapPairs(null));
        executeTest(new Node("A"), new Node("A"));
        executeTest(new ListBuilder().withValue("A").withValue("B").build(), new ListBuilder().withValue("B").withValue("A").build());
        executeTest(new ListBuilder().withValue("A").withValue("B").withValue("C").build(), new ListBuilder().withValue("B").withValue("A").withValue("C").build());
        executeTest(new ListBuilder().withValue("B").withValue("A").withValue("D").withValue("C").build(), new ListBuilder().withValue("A").withValue("B").withValue("C").withValue("D").build());
    }

    // use this to build your own tests
    private class ListBuilder {
        private Node head = null, last = null;

        public ListBuilder withValue(String value) {
            if (head == null) {
                head = new Node(value);
                last = head;
            } else {
                last.next = new Node(value);
                last = last.next;
            }
            return this;
        }

        public Node build() {
            return head;
        }
    }

    private static void executeTest(Node input, Node expectedResult) {
        Node output = Kata.swapPairs(input);
        if (expectedResult == null) {
            assertNull(output);
            return;
        }

        final String expected = expectedResult.printList();
        final String actual = output.printList();
        final String errMsg = "Expected '" + expected;
        assertEquals(errMsg, expected, actual);
    }
}
