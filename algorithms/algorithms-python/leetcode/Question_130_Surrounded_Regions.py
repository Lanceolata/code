#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return
        m, n = len(board), len(board[0])
        for i in range(n):
            if board[0][i] == 'O':
                self.helper(board, 0, i, m, n)
            if board[m-1][i] == 'O':
                self.helper(board, m-1, i, m, n)
        for i in range(m):
            if board[i][0] == 'O':
                self.helper(board, i, 0, m, n)
            if board[i][n-1] == 'O':
                self.helper(board, i, n-1, m, n)

        for i in range(m):
            for j in range(n):
                if board[i][j] == "O":
                    board[i][j] = "X"
                if board[i][j] == "$":
                    board[i][j] = "O"
        
    def helper(self, board, i, j, m, n):
        board[i][j] = "$"
        if i - 1 >= 0 and board[i-1][j] == "O":
            self.helper(board, i-1, j, m, n)
        if i + 1 < m and board[i+1][j] == "O":
            self.helper(board, i+1, j, m, n)
        if j - 1 >= 0 and board[i][j-1] == "O":
            self.helper(board, i, j-1, m, n)
        if j + 1 < n and board[i][j+1] == "O":
            self.helper(board, i, j+1, m, n)
