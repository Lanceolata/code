#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def robotSim(self, commands, obstacles):
        """
        :type commands: List[int]
        :type obstacles: List[List[int]]
        :rtype: int
        """
        obs = set([(i[0], i[1]) for i in obstacles])
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        curDir, res = 0, 0
        cur = (0, 0)
        for c in commands:
            if c == -2:
                curDir -= 1
                if curDir == -1:
                    curDir = 3
            elif c == -1:
                curDir += 1
                curDir %= 4
            else:
                for i in range(c):
                    next = (cur[0] + dirs[curDir][0], cur[1] + dirs[curDir][1])
                    if next in obs:
                        break
                    cur = next

                res = max(res, cur[0] * cur[0] + cur[1] * cur[1])
        return res
