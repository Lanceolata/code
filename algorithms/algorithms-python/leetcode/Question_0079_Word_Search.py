#!/usr/bin/python
# coding: utf-8

class Solution(object):
    dr = [1, 0, -1, 0]
    dc = [0, 1, 0, -1]
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        m, n = len(board), len(board[0])
        visited = [[False] * n for i in range(m)]
        for i in range(m):
            for j in range(n):
                if self.isThisWay(board, word, i, j, 0, visited):
                    return True
        return False

    def isThisWay(self, board, word, row, col, index, visited):
        if row < 0 or row >= len(board) or col < 0 or col >= len(board[0]) or \
            visited[row][col] or board[row][col] != word[index]:
            return False
        
        index += 1
        if index == len(word):
            return True
        visited[row][col] = True
        for i in range(4):
            if self.isThisWay(board, word, row + self.dr[i], col + self.dc[i], index, visited):
                return True
        visited[row][col] = False
        return False
