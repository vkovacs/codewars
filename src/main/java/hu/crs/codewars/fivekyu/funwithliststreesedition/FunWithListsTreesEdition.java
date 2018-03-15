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
        if (head == null) {
            return null;
        }

        Set<Integer> integerSet = new TreeSet<>();
        integerSet.addAll(flatten(head.getData(), integerSet));
        while (head.getNext() != null) {
            head = head.getNext();
            integerSet.addAll(flatten(head.getData(), integerSet));
        }

        for (Integer integer : integerSet) {
            System.out.println(integer);
        }
        ArrayList<Integer> integerList = new ArrayList<>(integerSet);

        return build(integerList, 0);
    }

    private static Set<Integer> flatten(TreeNode treeNode, Set<Integer> integers) {
        if (treeNode.getLeft() != null) {
            integers.addAll(flatten(treeNode.getLeft(), integers));
        }
        if (treeNode.getRight() != null) {
            integers.add(treeNode.getValue());
            integers.addAll(flatten(treeNode.getRight(), integers));
        }
        integers.add(treeNode.getValue());
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
