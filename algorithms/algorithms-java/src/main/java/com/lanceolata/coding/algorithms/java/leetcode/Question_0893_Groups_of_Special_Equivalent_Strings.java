package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question_0893_Groups_of_Special_Equivalent_Strings {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> set = new HashSet<>();
        for (String w : words) {
            int n = (w.length() + 1) / 2;
            char[] s1 = new char[n], s2 = new char[n];
            for (int i = 0; i < w.length(); i++) {
                if (i % 2 == 0) {
                    s1[i / 2] = w.charAt(i);
                } else {
                    s2[i / 2] = w.charAt(i);
                }
            }
            Arrays.sort(s1);
            Arrays.sort(s2);
            set.add(new String(s1) + "_" + new String(s2));
        }
        return set.size();
    }
}
