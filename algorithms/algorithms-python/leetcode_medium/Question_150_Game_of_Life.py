#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        m, n = len(board), len(board[0])
        dx = [-1, -1, -1, 0, 1, 1, 1, 0]
        dy = [-1, 0, 1, 1, 1, 0, -1, -1]
        for i in range(m):
            for j in range(n):
                cnt = 0
                for k in range(8):
                    x, y = i + dx[k], j + dy[k]
                    if x >= 0 and x < m and y >= 0 and y < n and (board[x][y] == 1 or board[x][y] == 2):
                        cnt += 1
                if board[i][j] == 1 and (cnt < 2 or cnt > 3):
                    board[i][j] = 2
                elif board[i][j] == 0 and cnt == 3:
                    board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                board[i][j] %= 2
                    
                