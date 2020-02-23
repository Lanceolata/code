#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        x = 0
        y = 0
        for c in moves:
            if c == "R":
                x -= 1
            elif c == "L":
                x += 1
            elif c == "U":
                y += 1
            elif c == "D":
                y -= 1
        return x == 0 and y == 0