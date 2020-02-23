#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def compress(self, chars):
        """
        :type chars: List[str]
        :rtype: int
        """
        anchor, write = 0, 0
        for i in range(len(chars)):
            if i + 1 == len(chars) or chars[i] != chars[i + 1]:
                chars[write] = chars[anchor]
                write += 1
                if i > anchor:
                    print str(i - anchor + 1)
                    for c in str(i - anchor + 1):
                        chars[write] = c
                        write += 1
                anchor = i + 1
        return write


sol = Solution()
sol.compress(["z","z","j"])
