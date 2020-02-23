#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        index, count = 0, 0
        for i in range(len(nums)):
            if i != 0 and nums[i - 1] == nums[i]:
                count += 1
                if count >= 2:
                    continue
            else:
                count = 0
            nums[index] = nums[i]
            index += 1
        return index
