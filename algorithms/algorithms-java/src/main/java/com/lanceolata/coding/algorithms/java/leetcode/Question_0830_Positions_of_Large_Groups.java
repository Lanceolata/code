package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0830_Positions_of_Large_Groups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int mlen = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            while (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                j++;
            }
            if (j - i + 1 >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                res.add(list);
            }
            i = j + 1;
        }
        return res;
    }
}
