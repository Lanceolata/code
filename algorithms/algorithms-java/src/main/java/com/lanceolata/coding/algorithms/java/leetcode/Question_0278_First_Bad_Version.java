package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0278_First_Bad_Version {
    public int firstBadVersion(int n) {
        int l = 1, r = n, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    boolean isBadVersion(int version) {
        return version >= 4;
    }
}
