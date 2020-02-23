#!/usr/bin/python
# coding: utf-8

from collections import Counter

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        return list((collections.Counter(nums1) & collections.Counter(nums2)).elements())

    def intersect_fast(self, nums1, nums2):
        count = {}
        res = []
        for i in nums1:
            count[i] = count.get(i, 0) + 1
        for i in nums2:
            if i in count and count[i] > 0:
                res.append(i)
                count[i] -= 1
        return res
