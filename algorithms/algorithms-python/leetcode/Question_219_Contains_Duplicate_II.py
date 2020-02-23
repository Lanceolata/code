#!/usr/bin/python
# coding: utf-8

from sets import Set

class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        s = Set()
        for i, v in enumerate(nums):
            if i > k:
                s.remove(nums[i - k - 1])
            if v in s:
                return True
            s.add(v)
        return False


nums = [1, 2, 3, 4, 5, 6, 7, 4]
sol = Solution()
print sol.containsNearbyDuplicate(nums, 5)
print sol.containsNearbyDuplicate(nums, 3)
