package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0949_Largest_Time_for_Given_Digits {
    public String largestTimeFromDigits(int[] arr) {
        int res = -1;
        for (int i1 = 0; i1 < arr.length; ++i1) {
            for (int i2 = 0; i2 < arr.length; ++i2) {
                for (int i3 = 0; i3 < arr.length; ++i3) {
                    if (i1 == i2 || i2 == i3 || i1 == i3) {
                        continue;
                    }
                    int i4 = 6 - i1 - i2 - i3;
                    int[] perm = {arr[i1], arr[i2], arr[i3], arr[i4]};
                    res = Math.max(res, validateTime(perm));
                }
            }
        }
        return res == -1 ? "" : String.format("%02d:%02d", res / 60, res % 60);
    }

    private int validateTime(int[] perm) {
        int hour = perm[0] * 10 + perm[1];
        int minute = perm[2] * 10 + perm[3];
        return hour < 24 && minute < 60 ? hour * 60 + minute : -1;
    }
}
