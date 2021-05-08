package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.TreeMap;

public class Question_0352_Data_Stream_as_Disjoint_Intervals {
    private TreeMap<Integer, int[]> treeMap;

    /** Initialize your data structure here. */
    public Question_0352_Data_Stream_as_Disjoint_Intervals() {
        treeMap = new TreeMap<>();
    }

    public void addNum(int val) {
        if (treeMap.containsKey(val)) {
            return;
        }
        Integer l = treeMap.lowerKey(val);
        Integer h = treeMap.higherKey(val);
        if (l != null && h != null && treeMap.get(l)[1] + 1 == val && h == val + 1) {
            treeMap.get(l)[1] = treeMap.get(h)[1];
            treeMap.remove(h);
        } else if (l != null && treeMap.get(l)[1] + 1 >= val) {
            treeMap.get(l)[1] = Math.max(treeMap.get(l)[1], val);
        } else if (h != null && h == val + 1) {
            treeMap.put(val, new int[] {val, treeMap.get(h)[1]});
            treeMap.remove(h);
        } else {
            treeMap.put(val, new int[] {val, val});
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[treeMap.size()][];
        treeMap.values().toArray(res);
        return res;
    }
}
