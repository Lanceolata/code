#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        m, a, b, i = [0] * 256, 0, 0, 0
        for s in secret:
            g = guess[i]
            i += 1
            a += 1 if s == g else 0
            if m[ord(s)] < 0:
                b += 1
            m[ord(s)] += 1
            if m[ord(g)] > 0:
                b += 1
            m[ord(g)] -= 1
        return "%dA%dB" % (a, b - a)

sol = Solution()
sol.getHint("1807", "7810")