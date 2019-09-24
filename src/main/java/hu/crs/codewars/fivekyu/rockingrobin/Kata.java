package hu.crs.codewars.fivekyu.rockingrobin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Kata implements Iterator<Integer> {

    private Iterator<Integer> it;

    public Kata(Collection<Iterator<Integer>> collections) {
        List<List<Integer>> lists = collectionLists(collections);
        List<Integer> roundRobinList = merge(lists);
        it = roundRobinList.iterator();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    private List<List<Integer>> collectionLists(Collection<Iterator<Integer>> collections) {
        List<List<Integer>> collectionLists = new ArrayList<>();
        for (Iterator<Integer> iterator : collections) {
            List<Integer> list = new ArrayList<>();
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
            collectionLists.add(list);
        }
        return collectionLists;
    }

    private List<Integer> merge(List<List<Integer>> lists) {
        List<Integer> mergedLists = new ArrayList<>();
        int[] currentListElementIndexes = new int[lists.size()];

        int currentListIndex = 0;
        Set<Integer> finishedListIndexes = new HashSet<>();

        while (finishedListIndexes.size() < lists.size()) {
            List<Integer> currentList = lists.get(currentListIndex);
            if (currentList.size() > currentListElementIndexes[currentListIndex]) {
                mergedLists.add(currentList.get(currentListElementIndexes[currentListIndex]));
                currentListElementIndexes[currentListIndex]++;
            } else {
                finishedListIndexes.add(currentListIndex);
            }

            currentListIndex++;
            if (currentListIndex == lists.size()) {
                currentListIndex = 0;
            }
        }
        return mergedLists;
    }
}
