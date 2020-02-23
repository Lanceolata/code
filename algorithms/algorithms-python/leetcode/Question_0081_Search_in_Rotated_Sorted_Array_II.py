#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        l, r, m = 0, len(nums) - 1, 0
        while l <= r:
            m = l + (r - l) / 2
            if nums[m] == target:
                return True
            if nums[m] == nums[l]:
                l += 1
            elif nums[m] > nums[l]:
                if nums[l] <= target and nums[m] > target:
                    r = m - 1
                else:
                    l = m + 1
            else:
                if nums[m] < target and nums[r] >= target:
                    l = m + 1
                else:
                    r = m - 1
        return False
