#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        row = [[False for _ in range(9)] for _ in range(9)]
        col = [[False for _ in range(9)] for _ in range(9)]
        area = [[False for _ in range(9)] for _ in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    continue
                
                k = int(board[i][j]) - 1
                p = i//3*3 + j//3;
                if row[i][k] or col[j][k] or area[p][k]:
                    return False

                row[i][k], col[j][k], area[p][k] = True, True, True
        return True
