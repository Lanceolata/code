#!/usr/bin/python
# coding: utf-8

import sys

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        m, n = len(nums1), len(nums2)
        left, right = (m + n + 1) / 2, (m + n) / 2 + 1
        if ((m + n) & 1) == 1:
            return self.findKth(nums1, 0, nums2, 0, left)
        else:
            return (self.findKth(nums1, 0, nums2, 0, left) + self.findKth(nums1, 0, nums2, 0, right)) / 2.0

    def findKth(self, nums1, i, nums2, j, k):
        if i >= len(nums1):
            return nums2[j + k - 1]
        if j >= len(nums2):
            return nums1[i + k - 1]
        if k == 1:
            return min(nums1[i], nums2[j])
        newI, newJ, newK = int(i + k / 2), int(j + k / 2), int(k - k / 2)
        mid1 = nums1[i + k / 2 - 1] if (i + k / 2 - 1) < len(nums1) else sys.maxint
        mid2 = nums2[j + k / 2 - 1] if (j + k / 2 - 1) < len(nums2) else sys.maxint
        if mid1 < mid2:
            return self.findKth(nums1, i + k / 2, nums2, j, k - k / 2)
        else:
            return self.findKth(nums1, i, nums2, j + k / 2, k - k / 2)
