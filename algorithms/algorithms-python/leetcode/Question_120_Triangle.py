#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        for i in range(len(triangle) - 2, -1, -1):
            cur, sub = triangle[i], triangle[i + 1]
            for j in range(len(cur)):
                cur[j] += min(sub[j], sub[j + 1])
        return triangle[0][0]
