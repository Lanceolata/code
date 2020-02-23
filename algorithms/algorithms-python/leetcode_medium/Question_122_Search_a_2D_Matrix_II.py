#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False
        x, y, r = 0, len(matrix[0]) - 1, len(matrix)
        while x < r and y >= 0:
            num = matrix[x][y]
            if num < target:
                x += 1
            elif num > target:
                y -= 1
            else:
                return True
        return False
