#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res, n, last, cur = 0, len(nums), 0, 0
        for i in range(n - 1):
            cur = max(cur, i + nums[i])
            if i == last:
                last = cur
                res += 1
                if cur >= n - 1:
                    break
        return res
