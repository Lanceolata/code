#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        if not heights:
            return 0
        res, stack, n = 0, [], len(heights)
        for i in range(n + 1):
            cur = 0 if i == n else heights[i]
            while stack and heights[stack[-1]] >= cur:
                h = heights[stack[-1]]
                stack.pop()
                w = i if not stack else i - stack[-1] - 1
                res = max(res, h * w)
            stack.append(i)
        return res
