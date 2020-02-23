#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        major = nums[0]
        count = 1
        for num in nums[1:]:
            if count == 0:
                major = num
                count = 1
            elif num == major:
                count += 1
            else:
                count -= 1
        return major
