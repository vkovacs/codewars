package hu.crs.codewars.fivekyu.swapnodepairslinkedlist;

//https://www.codewars.com/kata/swap-node-pairs-in-linked-list/train/java
public class Kata {
    public static Node swapPairs(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        Node first = head;
        Node second = head.next;

        Node newFirst = swap(first, second);
        Node newHead = newFirst;
        Node newSecond = newFirst.next;

        while (hasNextPairNode(newFirst) && hasNextPairNode(newSecond)) {
            Node newNewFirst = swap(newFirst.next.next, newSecond.next.next);
            newSecond.next = newNewFirst;
            newFirst = newNewFirst;
            newSecond = newNewFirst.next;
        }

        return newHead;
    }

    private static boolean hasNextPairNode(Node node) {
        return node.next != null && node.next.next != null;

    }

    private static Node swap(Node first, Node second) {
        Node originalSecondNext = second.next;
        second.next = first;
        first.next = originalSecondNext;
        return second;
    }
}
