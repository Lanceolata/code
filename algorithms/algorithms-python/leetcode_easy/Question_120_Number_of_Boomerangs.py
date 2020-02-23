#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def numberOfBoomerangs(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        l = len(points)
        m = {}
        res = 0
        for i in range(l):
            for j in range(l):
                if i == j:
                    continue
                dx = points[i][0] - points[j][0]
                dy = points[i][1] - points[j][1]
                d = dx * dx + dy * dy
                if d in m:
                    m[d] += 1
                else:
                    m[d] = 1
            for k, v in m.items():
                res += v * (v - 1)
            m.clear()
        return res

sol = Solution()
print sol.numberOfBoomerangs([[0,0],[1,0],[2,0]])
