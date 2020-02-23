#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def peakIndexInMountainArray(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        if not A or len(A) < 3:
            return -1
        l, r, mid = 0, len(A) - 1, 0
        while l < r:
            mid = l + (r - l) / 2
            if A[mid] < A[mid + 1]:
                l = mid + 1
            else:
                r = mid
        return l