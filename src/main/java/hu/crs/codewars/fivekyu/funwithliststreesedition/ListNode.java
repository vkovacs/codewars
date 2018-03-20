package hu.crs.codewars.fivekyu.funwithliststreesedition;

public class ListNode {
    public final TreeNode data;
    public final ListNode next;

    public ListNode(TreeNode data) {
        this.data = data;
        next = null;
    }

    public ListNode(TreeNode data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}
