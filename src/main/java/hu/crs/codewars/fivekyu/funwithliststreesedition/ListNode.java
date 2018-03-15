package hu.crs.codewars.fivekyu.funwithliststreesedition;

public class ListNode {
    public TreeNode data;
    public ListNode next;

    public ListNode(TreeNode data) {
        this.data = data;
    }

    public ListNode(TreeNode data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}
