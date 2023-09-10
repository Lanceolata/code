package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1013_Partition_Array_Into_Three_Parts_With_Equal_Sum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int parts = 0, v = sum / 3;
        for (int i = 0, cur = 0; i < arr.length; i++) {
            cur += arr[i];
            if (cur == (parts + 1) * v) {
                parts++;
            }
        }
        return parts >= 3;
    }
}
