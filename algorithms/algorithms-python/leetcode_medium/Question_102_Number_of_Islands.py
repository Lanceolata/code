#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0
        m, n, res = len(grid), len(grid[0]), 0
        visited = [[False] * n for i in range(m)]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and not visited[i][j]:
                    self.numIslandsDFS(grid, visited, i, j, m, n)
                    res += 1
        return res

    def numIslandsDFS(self, grid, visited, i, j, m, n):
        if i < 0 or i >= m or j < 0 or j >= n:
            return
        if grid[i][j] != '1' or visited[i][j]:
            return
        visited[i][j] = True
        self.numIslandsDFS(grid, visited, i - 1, j, m, n)
        self.numIslandsDFS(grid, visited, i + 1, j, m, n)
        self.numIslandsDFS(grid, visited, i, j - 1, m, n)
        self.numIslandsDFS(grid, visited, i, j + 1, m, n)
