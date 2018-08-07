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

        Node newHead = swap(head, head.next);
        Node newFirst = newHead;
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

    private static Node swap(Node node0, Node node1) {
        node0.next = node1.next;
        node1.next = node0;
        return node1;
    }
}
