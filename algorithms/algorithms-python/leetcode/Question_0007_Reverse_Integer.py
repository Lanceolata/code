#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        # python % 无法区分正负  需要自行处理
        tag = 1
        if x < 0 :
            tag = -1
            x = -x
        result = 0
        while x != 0:
            tmp = result * 10 + x % 10
            if tmp / 10 != result:
                return 0
            result = tmp
            x /= 10
        return tag * result

    def reverse2(self, x):
        # 获得符号
        s = cmp(x, 0)
        # 反转字符串
        r = int(str(s * x)[::-1])
        # 如果大于2**31 则r < 2**31 为 0
        return s*r * (r < 2**31)
