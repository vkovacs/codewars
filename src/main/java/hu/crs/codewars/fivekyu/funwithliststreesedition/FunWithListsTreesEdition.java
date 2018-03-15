package hu.crs.codewars.fivekyu.funwithliststreesedition;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Fun with lists: trees edition
 * <p>
 * https://www.codewars.com/kata/fun-with-lists-trees-edition/train/java
 */
public class FunWithListsTreesEdition {
    static TreeNode flatten(ListNode head) {
        if (head == null) {return null;}

        Set<Integer> integers = new TreeSet<>(flatten(head.data, new TreeSet<>()));
        while (head.next != null) {
            head = head.next;
            integers.addAll(flatten(head.data, integers));
        }

        return build(new ArrayList<>(integers), 0);
    }

    private static Set<Integer> flatten(TreeNode treeNode, Set<Integer> integers) {
        if (treeNode.left != null) {
            integers.addAll(flatten(treeNode.left, integers));
        }
        if (treeNode.right != null) {
            integers.add(treeNode.value);
            integers.addAll(flatten(treeNode.right, integers));
        }
        integers.add(treeNode.value);
        return integers;
    }

    private static TreeNode build(List<Integer> integers, int index) {
        if (index * 2 + 1 < integers.size() - 1 && index * 2 + 2 <= integers.size() - 1) {
            return new TreeNode(integers.get(index), build(integers, index * 2 + 1 ), build(integers, index * 2 + 2));
        } else if (index * 2 + 1 <= integers.size() - 1 && index * 2 + 2 > integers.size() - 1) {
            return new TreeNode(integers.get(index), build(integers, index * 2 + 1 ), null);
        } else if (index * 2 + 1 > integers.size() -1) {
            return new TreeNode(integers.get(index), null, null);
        }
        return null;
    }
}
