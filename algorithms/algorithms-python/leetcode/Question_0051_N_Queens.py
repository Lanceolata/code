#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        row, col, main, anti, res = [0] * n, [True] * n, [True] * (2 * n - 1), [True] * (2 * n - 1), []
        self.dfs(0, n, row, col, main, anti, res)
        return res
    
    def dfs(self, i, n, row, col, main, anti, res):
        if i == n:
            res.append(["."*i + "Q" + "."*(n-i-1) for i in row])
            return
        for j in range(n):
            if col[j] and main[i + j] and anti[i + n - 1 - j]:
                row[i] = j
                col[j], main[i + j], anti[i + n - 1 - j] = False, False, False
                self.dfs(i + 1, n, row, col, main, anti, res)
                col[j], main[i + j], anti[i + n - 1 - j] = True, True, True
