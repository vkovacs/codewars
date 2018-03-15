package hu.crs.codewars.fivekyu.funwithliststreesedition;

public class ListNode {
    private TreeNode data;
    private ListNode next;

    public ListNode(TreeNode data) {
        this.data = data;
    }

    public ListNode(TreeNode data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public TreeNode getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }
}
