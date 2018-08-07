package hu.crs.codewars.fivekyu.swapnodepairslinkedlist;

public class Node {
    private String value;
    public Node next;

    public Node(String value) { this.value = value; }

    public String getValue() { return value; }

    public String toString() { return this.value; }

    public String printList() {
      if (this.next == null) return this.toString() + " ->";
      return this.toString() + " -> " + next.printList();
    }
}