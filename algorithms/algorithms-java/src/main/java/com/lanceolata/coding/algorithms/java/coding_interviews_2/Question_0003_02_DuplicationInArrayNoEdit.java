package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0003_02_DuplicationInArrayNoEdit {
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || numbers.length != length) {
            return false;
        }
        int l = 1, r = length - 1, m = 0;
        while (l < r) {
            // 对1 ~ length - 1 的数字进行二分
            m = l + (r - l) / 2;
            // 统计 l ~ m 数字的个数
            int count = countRange(numbers, l, m);
            if (count > m - l + 1) {
                // 个数 大于 l ~ m的长度  则重复数字在 l ~ m中
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (countRange(numbers, l, l) > 1) {
            duplication[0] = l;
            return true;
        }
        return false;
    }

    private int countRange(int[] numbers, int l, int r) {
        int count = 0;
        for (int n : numbers) {
            if (n >= l && n <= r) {
                count++;
            }
        }
        return count;
    }
}
