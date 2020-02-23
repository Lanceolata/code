#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        k = m + n
        while n > 0:
            if m > 0 and nums1[m - 1] > nums2[n - 1]:
                nums1[k - 1] = nums1[m - 1]
                k, m = k - 1, m - 1
            else:
                nums1[k - 1] = nums2[n - 1]
                k, n = k - 1, n - 1
