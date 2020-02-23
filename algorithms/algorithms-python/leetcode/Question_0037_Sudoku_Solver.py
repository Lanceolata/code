#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if not board or len(board) != 9 or len(board[0]) != 9:
            return
        self.help(board, 0, 0)

    def help(self, board, i, j):
        if i >= 9:
            return True
        if j >= 9:
            return self.help(board, i + 1, 0)
        if board[i][j] == '.':
            for m in '123456789':
                board[i][j] = m
                if self.isValid(board, i, j) and self.help(board, i, j + 1):
                    return True
                board[i][j] = '.'
        else:
            return self.help(board, i, j + 1)
        return False


    def isValid(self, board, i, j):
        for m in range(9):
            if m != i and board[i][j] == board[m][j]:
                return False
            if m != j and board[i][j] == board[i][m]:
                return False
        row, col = i / 3 * 3, j / 3 * 3
        for m in range(row, row + 3):
            for n in range(col, col + 3):
                if (m != i or n != j) and board[i][j] == board[m][n]:
                    return False
        return True
