package hu.crs.codewars.fivekyu.funwithliststreesedition;

import java.util.Objects;

public class TreeNode {
    public final int value;
    public final TreeNode left;
    public final TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return value == treeNode.value &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }
}
