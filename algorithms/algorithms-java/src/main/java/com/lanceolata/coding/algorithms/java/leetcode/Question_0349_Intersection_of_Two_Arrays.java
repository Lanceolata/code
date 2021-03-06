package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0349_Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return nums1 == null ? nums2 : nums1;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0, m = nums1.length, n = nums2.length;
        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                while (i < m - 1 && nums1[i] == nums1[i + 1]) {
                    i++;
                }
                while (j < n - 1 && nums2[j] == nums2[j + 1]) {
                    j++;
                }
                i++; j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return nums1 == null ? nums2 : nums1;
        }
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set2.add(n);
        }
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int i = 0;
        for (int n : set1) {
            res[i++] = n;
        }
        return res;
    }
}
