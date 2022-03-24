package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question_0833_Find_And_Replace_in_String {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0; i < indices.length; i++) {
            sorted.add(new int[]{indices[i], i});
        }
        Collections.sort(sorted, Comparator.comparing(i -> -i[0]));
        for (int[] ind : sorted) {
            int i = ind[0], j = ind[1];
            String str = sources[j], t = targets[j];
            if (i + str.length() <= s.length() && s.substring(i, i + str.length()).equals(str)) {
                s = s.substring(0, i) + t + s.substring(i + str.length());
            }
        }
        return s;
    }
}
