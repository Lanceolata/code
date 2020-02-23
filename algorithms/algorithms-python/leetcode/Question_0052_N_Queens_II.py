#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """
        col, main, anti, res = [True] * n, [True] * (2 * n - 1), [True] * (2 * n - 1), [0]
        self.dfs(0, n, col, main, anti, res)
        return res[0]

    def dfs(self, i, n, col, main, anti, res):
        if i == n:
            res[0] += 1
            return
        for j in range(n):
            if col[j] and main[i + j] and anti[i + n - 1 - j]:
                col[j], main[i + j], anti[i + n - 1 - j] = False, False, False
                self.dfs(i + 1, n, col, main, anti, res)
                col[j], main[i + j], anti[i + n - 1 - j] = True, True, True
