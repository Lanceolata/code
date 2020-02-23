#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        row = len(M)
        col = len(M[0])

        res = []
        for i in range(row):
            res.append([0] * col)

        for i in range(row):
            for j in range(col):
                count = 0
                for m in range(i - 1, i + 2):
                    for n in range(j - 1, j + 2):
                        if m >= 0 and m < row and n >= 0 and n < col:
                            res[i][j] += M[m][n]
                            count += 1
                res[i][j] /= count

        return res