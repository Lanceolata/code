package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0825_Friends_Of_Appropriate_Ages {
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int age : ages) {
            count.put(age, count.getOrDefault(age, 0) + 1);
        }
        int res = 0;
        for (Integer a : count.keySet()) {
            for (Integer b : count.keySet()) {
                if (request(a, b)) {
                    res += count.get(a) * (count.get(b) - (a.equals(b) ? 1 : 0));
                }
            }
        }
        return res;
    }

    private boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
    }
}
