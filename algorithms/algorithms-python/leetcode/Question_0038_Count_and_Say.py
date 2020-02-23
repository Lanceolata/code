#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n <= 0:
            return ""
        res = ["1"]
        while n - 1:
            n -= 1
            count = 1
            cur = res[0]
            temp = []
            for i in range(1, len(res)):
                if res[i] == cur:
                    count += 1
                else:
                    temp.append(str(count))
                    temp.append(cur)
                    count = 1
                    cur = res[i]
            temp.append(str(count))
            temp.append(cur)
            res = temp

        return "".join(res)
