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
        row, col = len(matrix) - 1, 0
        while row >= 0 and col < len(matrix[0]):
            v = matrix[row][col]
            if v > target:
                row -= 1
            elif v < target:
                col += 1
            else:
                return True
        return False
