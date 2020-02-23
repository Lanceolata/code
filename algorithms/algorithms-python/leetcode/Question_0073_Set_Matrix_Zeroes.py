#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if not matrix or not matrix[0]:
            return
        m, n = len(matrix), len(matrix[0])
        row, col = False, False
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0

                    if i == 0:
                        row = True
                    if j == 0:
                        col = True

        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0
        
        if row:
            for i in range(n):
                matrix[0][i] = 0
        if col:
            for i in range(m):
                matrix[i][0] = 0
