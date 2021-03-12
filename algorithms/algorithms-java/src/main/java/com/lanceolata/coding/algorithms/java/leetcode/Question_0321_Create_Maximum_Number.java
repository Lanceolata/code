package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0321_Create_Maximum_Number {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= Math.min(n, k); ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (isGreater(candidate, 0, ans, 0)) {
                ans = candidate;
            }
        }
        return ans;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r) {
            ans[r] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return ans;
    }

    public boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++; j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public int[] maxArray(int[] arr, int k) {
        int p = -1;
        int[] nums = new int[k];
        if (k == 0) {
            return nums;
        }
        for (int i = 0; i < arr.length; i++) {
            while (p >= 0 && nums[p] < arr[i] && (arr.length - i + p + 1) > k) {
                p--;
            }
            if (p < nums.length - 1) {
                p++;
                nums[p] = arr[i];
            }
        }
        return nums;
    }
}
