#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        s = set(nums1) & set(nums2)
        return [i for i in s]
