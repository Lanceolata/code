#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix or not matrix[0]:
            return 0
        m, n, res, pre = len(matrix), len(matrix[0]), 0, 0
        dp = [0] * (n + 1)
        for i in range(m):
            for j in range(1, n + 1):
                tmp = dp[j]
                if matrix[i][j - 1] == '1':
                    dp[j] = min(dp[j], dp[j - 1], pre) + 1
                    res = max(res, dp[j])
                else:
                    dp[j] = 0
                pre = tmp
        return res * res
