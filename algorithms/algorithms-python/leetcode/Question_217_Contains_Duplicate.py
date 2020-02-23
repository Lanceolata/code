#!/usr/bin/python
# coding: utf-8

from sets import Set

class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        s = Set()
        for i in nums:
            if i in s:
                return True
            s.add(i)
        return False


nums = [1, 2, 3, 1]
sol = Solution()
print sol.containsDuplicate(nums)
