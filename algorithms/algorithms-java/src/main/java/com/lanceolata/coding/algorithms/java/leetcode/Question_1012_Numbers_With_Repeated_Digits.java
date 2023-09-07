package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question_1012_Numbers_With_Repeated_Digits {
    public int numDupDigitsAtMostN(int n) {
        // Transform n + 1 to arrayList
        List<Integer> list = new ArrayList<Integer>();
        for (int x = n + 1; x > 0; x /= 10) {
            list.add(0, x % 10);
        }

        // Count the number with digits < n
        int res = 0, size = list.size();
        for (int i = 1; i < size; i++) {
            res += 9 * count(9, i - 1);
        }

        // Count the number with same prefix
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = i > 0 ? 0 : 1; j < list.get(i); j++) {
                if (!seen.contains(j)) {
                    res += count(9 - i, size - i - 1);
                }
            }
            if (seen.contains(list.get(i))) {
                break;
            }
            seen.add(list.get(i));
        }
        return n - res;
    }

    private int count(int m, int n) {
        return n == 0 ? 1 : count(m, n - 1) * (m - n + 1);
    }
}
