package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0381_Insert_Delete_GetRandom_O1_Duplicates_allowed {
    private List<Integer> lst;
    private Map<Integer, Set<Integer>> idx;
    private Random rand = new Random();

    /** Initialize your data structure here. */
    public Question_0381_Insert_Delete_GetRandom_O1_Duplicates_allowed() {
        lst = new ArrayList<>();
        idx = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!idx.containsKey(val)) {
            idx.put(val, new LinkedHashSet<>());
        }
        idx.get(val).add(lst.size());
        lst.add(val);
        return idx.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val) || idx.get(val).size() == 0) {
            return false;
        }
        int removeIdx = idx.get(val).iterator().next();
        idx.get(val).remove(removeIdx);
        int last = lst.get(lst.size() - 1);
        lst.set(removeIdx, last);
        idx.get(last).add(removeIdx);
        idx.get(last).remove(lst.size() - 1);

        lst.remove(lst.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return lst.get(rand.nextInt(lst.size()));
    }
}
