package com.lanceolata.coding.algorithms.java.coding_interviews_2;

import java.util.ArrayList;

public class Question_0057_02_ContinuousSquenceWithSum {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        if (sum <= 0) {
            return res;
        }
        int l = 1, r = 2, cur;
        while (l < r) {
            cur = (l + r) * (r - l + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    list.add(i);
                }
                res.add(list);
                l++;
            } else if (cur < sum) {
                r++;
            } else {
                l++;
            }
        }
        return res;
    }
}
