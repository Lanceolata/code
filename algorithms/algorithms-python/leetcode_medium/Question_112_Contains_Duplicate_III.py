#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        if t == 0 and len(nums) == len(set(nums)): return False # no duplicate
        n = len(nums)
        for i in xrange(n):
            for j in xrange(1, k+1):
                if i+j >= n: break
                if abs(nums[i+j]-nums[i]) <= t: return True
        return False
                
