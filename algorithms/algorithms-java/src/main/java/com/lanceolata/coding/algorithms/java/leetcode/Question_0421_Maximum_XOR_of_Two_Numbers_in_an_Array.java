package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Question_0421_Maximum_XOR_of_Two_Numbers_in_an_Array {
    public int findMaximumXOR(int[] nums) {
        int res = 0, mask = 0;
        for (int i = 31; i >= 0; --i) {
            mask |= (1 << i);
            Set<Integer> s = new HashSet<>();
            for (int num : nums) {
                s.add(num & mask);
            }
            int t = res | (1 << i);
            for (int prefix : s) {
                if (s.contains(t ^ prefix)) {
                    res = t;
                    break;
                }
            }
        }
        return res;
    }
}
