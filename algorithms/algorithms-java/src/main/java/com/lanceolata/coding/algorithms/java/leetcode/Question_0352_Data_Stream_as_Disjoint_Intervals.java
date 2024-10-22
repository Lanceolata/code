package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.TreeMap;

public class Question_0352_Data_Stream_as_Disjoint_Intervals {
    private TreeMap<Integer, int[]> treeMap;

    /** Initialize your data structure here. */
    public Question_0352_Data_Stream_as_Disjoint_Intervals() {
        treeMap = new TreeMap<>();
    }

    public void addNum(int value) {
        if (treeMap.containsKey(value)) {
            return;
        }
        Integer l = treeMap.lowerKey(value);
        Integer h = treeMap.higherKey(value);
        if (l != null && h != null && treeMap.get(l)[1] + 1 == value && h == value + 1) {
            treeMap.get(l)[1] = treeMap.get(h)[1];
            treeMap.remove(h);
        } else if (l != null && treeMap.get(l)[1] + 1 >= value) {
            treeMap.get(l)[1] = Math.max(treeMap.get(l)[1], value);
        } else if (h != null && h == value + 1) {
            treeMap.put(value, new int[] {value, treeMap.get(h)[1]});
            treeMap.remove(h);
        } else {
            treeMap.put(value, new int[] {value, value});
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[treeMap.size()][];
        treeMap.values().toArray(res);
        return res;
    }
}
