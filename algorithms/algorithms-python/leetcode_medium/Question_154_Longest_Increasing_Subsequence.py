#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dp = []
        for i in nums:
            l, r = 0, len(dp)
            while l < r:
                mid = l + (r - l) / 2
                if dp[mid] < i:
                    l = mid + 1
                else:
                    r = mid
            if r >= len(dp):
                dp.append(i)
            else:
                dp[r] = i
        return len(dp)