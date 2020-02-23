#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        res, left, left_max, right, right_max = 0, 0, 0, len(height) - 1, 0
        while left < right:
            if height[left] < height[right]:
                if height[left] >= left_max:
                    left_max = height[left]
                else:
                     res += left_max - height[left]
                left += 1
            else:
                if height[right] >= right_max:
                    right_max = height[right]
                else:
                    res += right_max - height[right]
                right -= 1
        return res
